import java.util.Scanner;
import java.io.*;

/**
* This is Main class that behaves as a driver class for all other classes. 
* Provides methods to Insert, Delete, Search, Save trees etc
* @author  Zain Bin Arshad
*/

public class TreeProfiler
{
	    
 /**
   * This main method which take user inputs and respond accordingly 
   * @param String[] args.
   * @return Nothing.
   * @throws FileNotFoundException, NullPointerException
   */	
	public static void main(String[] args) throws Exception{
	
		TreeProfiler object = new TreeProfiler();
		Scanner scanInput = new Scanner(System.in);
		try{
			/* Interactive Mode
			*  As No information given to which tree to use in this mode,
			*  So, I am using Binary Seacrh Tree  
			*/
			int Date, Volume;
			float Open, High, Low, Close;
			double time = 0.0;
			long  start, end;
			String key, Ticker, fileName;
			BST bst = new BST();
			if(args[0].toLowerCase().equals("-i")){
				int choice;
				do{
					choice = object.Menu();
					switch(choice){
						// load data and insert into tree
						case 1:
							try{
								System.out.printf("Load Stock Data / Saved Tree <stock/saved> ? : ");
								String load = scanInput.nextLine().toLowerCase();
								if(load.equals("stock")){
									System.out.printf("Please Input File Name: ");
									fileName = scanInput.nextLine();
									File file = new File(fileName+".txt");
									Scanner scanFile = new Scanner(file);
									bst = new BST();
									String[] values;
									start = System.nanoTime();  // store time taken for insertion
									while (scanFile.hasNextLine())
									{
										values = scanFile.nextLine().split(",");  // store each value in String[]
										Ticker = values[0];
										Date = Integer.parseInt(values[1]);
										Open = Float.parseFloat(values[2]);
										High = Float.parseFloat(values[3]);
										Low = Float.parseFloat(values[4]);
										Close = Float.parseFloat(values[5]);
										Volume = Integer.parseInt(values[6]);
										// Inserting AccountData into tree
										bst.insert(new AccountData(Ticker, Date, Open, High, Low, Close, Volume)); 
									}
									end = System.nanoTime();
									time = (double)(end - start)/10000000000L;
									System.out.println("Your file has been Loaded and Inserted into Tree.");
								}
								else if(load.equals("saved")){
									System.out.printf("Please Input File Name: ");
									String name = scanInput.nextLine();
									FileInputStream file = new FileInputStream( name+".ser" );
									ObjectInputStream input = new ObjectInputStream( file );
									bst =  new BST();
									bst = (BST)input.readObject();
									input.close();
									System.out.println("Your file has been Loaded and Inserted into Tree.");
								}
								else
									System.out.println("Invalid Input !");
							}
							catch(Exception e)
							{
								System.out.println(e.toString());
							}
						break;
						
						// search key
						case 2:
							System.out.printf("Enter Key to seacrh: ");
							key = scanInput.nextLine();
							if(!(bst.search(key)))
								System.out.println("Key NOT Found !");
						break;
							
						// insert AccountData	
						case 3:
							try{
								System.out.print("Enter Ticker(AlphaNumeric) : ");
								Ticker = scanInput.next();
								System.out.print("Enter Date(Int) : ");
								Date = scanInput.nextInt();
								System.out.print("Enter Open(Float) : ");
								Open = scanInput.nextFloat();
								System.out.print("Enter High(Float) : ");
								High = scanInput.nextFloat();
								System.out.print("Enter Low(Float) : ");
								Low = scanInput.nextFloat();
								System.out.print("Enter Close(Float) : ");
								Close = scanInput.nextFloat();
								System.out.print("Enter Volume(int) : ");
								Volume = scanInput.nextInt();
								bst.insert(new AccountData(Ticker, Date, Open, High, Low, Close, Volume));
							}
							catch(Exception e){
								System.out.println("Invalid Input !");
							}
						break;
						
						// delete key
						case 4:
							System.out.printf("Enter Key to delete: ");
							key = scanInput.next();
							if(bst.search(key)){
								bst.delete(key);
								System.out.printf("NODE DELETED !\n");
							}
							else
								System.out.printf("NOT FOUND... Key can't be deleted ! ");
							
						break;
						
						// Print stats
						case 5:
							try{
								System.out.println("Size     : "+ bst.getSize());
								System.out.println("Hieght   : "+ bst.getHeight());
								System.out.printf("Balanced : %.2f%%\n", bst.getBalance());
								System.out.printf("Insertion Time : %.3f seconds\n", time);
												
								System.out.println("Do you want to Save these Stats (y/n) ?");
								String in = scanInput.nextLine().toLowerCase();
								if(in.equals("y")){
									System.out.printf("Enter Filename to be saved : ");
									fileName = scanInput.nextLine();
									PrintWriter out = new PrintWriter(fileName+".txt");
									out.println("\n\n ======= Binary Seacrh Tree Statistics =======\n\n");
									out.println("Size     : "+ bst.getSize());
									out.println("Hieght   : "+ bst.getHeight());
									out.println("Balanced : "+ bst.getBalance());
									out.println("Insertion Time : "+ time + "seconds\n");
									out.close();
								}
								else if(in.equals("n")){
									
								}
								else
									System.out.println("Invalid Input !");
							}
							catch(Exception e){
								System.out.println(e.toString());
							}
						break;
						
						// save tree
						case 6:
						try{
							System.out.printf("Please Input File Name to be stored: ");
							String name = scanInput.next();
							System.out.println("Tree have been saved in file: " + name + ".ser");
							// OutputStream file = new FileOutputStream( name+".ser" );
							// ObjectOutputStream output = new ObjectOutputStream( file );
							// output.writeObject(bst);
							// output.close();
						}
						catch(Exception e){
							System.out.println(e.toString());
						}
						break;
					}
				}while(choice != 0);
			}
			// Profiling Mode
			else if(args[0].toLowerCase().equals("-p") 
				    && (args[1].toLowerCase().equals("bst") 
						|| args[1].toLowerCase().equals("btree") 
						||args[1].toLowerCase().equals("avltree")) 
					&& args[2] instanceof String){
				boolean bstB = false, btreeB = false, avlB = false;
				bst = new BST();
				BTree btree = new BTree();
				AVLTree avltree = new AVLTree();
				int order =0;
				if(args[1].toLowerCase().equals("bst")){
					bstB = true;
				}
				else if(args[1].toLowerCase().equals("btree")){
					System.out.printf("Enter Keys per Node : ");
					order = scanInput.nextInt() -1;
					while(order < 2){
						System.out.println("Keys must be >= 3 ! ");
						System.out.printf("Enter key again : ");
						order = scanInput.nextInt() -1;
					}
					btree = new BTree(order);
					btreeB = true;
				}
				else{
					avlB = true;	
				}
					
				try{
					File file = new File(args[2]+".txt");
					Scanner scanFile = new Scanner(file);
					String[] values;
					start = System.nanoTime();
					while (scanFile.hasNextLine())
					{
						values = scanFile.nextLine().split(",");  // store each value in String[]
						Ticker = values[0];
						Date = Integer.parseInt(values[1]);
						Open = Float.parseFloat(values[2]);
						High = Float.parseFloat(values[3]);
						Low = Float.parseFloat(values[4]);
						Close = Float.parseFloat(values[5]);
						Volume = Integer.parseInt(values[6]);
						// Inserting AccountData into tree
						if(bstB)
							bst.insert(new AccountData(Ticker, Date, Open, High, Low, Close, Volume));
						else if(avlB)
							avltree.insert(new AccountData(Ticker, Date, Open, High, Low, Close, Volume));
						else
							btree.insert(new AccountData(Ticker, Date, Open, High, Low, Close, Volume));
					}
					end = System.nanoTime();
					time = (double)(end - start)/10000000000L;
					if(bstB){
						System.out.println("Size     : "+ bst.getSize());
						System.out.println("Hieght   : "+ bst.getHeight());
						System.out.printf("Balanced : %.2f\n%%", bst.getBalance());
						System.out.printf("Insertion Time : %.3f seconds\n", time);
					}
					else if(btreeB){
						System.out.println("Size   : "+ btree.getSize());
						System.out.println("Hieght : "+ btree.getHeight());
						System.out.println("Order  : "+ btree.order);
						// not been able to build this logic
						//System.out.println("Balanced : "+ btree.getBalance());
						System.out.printf("Insertion Time : %.3f seconds\n", time);
					}
					else{
						System.out.println("Size     :  " + avltree.getSize());
						System.out.println("Height   :  " + avltree.getHeight());
						System.out.printf("Balanced :  %.2f%%\n", avltree.getBalance());
						System.out.printf("Insertion Time : %.3f seconds\n", time);
					}
												
					System.out.printf("Do you want to Save these Stats (y/n) ?");
					String in = scanInput.next().toLowerCase();
					if(in.equals("y")){
						System.out.printf("Enter Filename to be saved : ");
						fileName = scanInput.next();
						PrintWriter out = new PrintWriter(fileName+".txt");
						if(bstB){
							out.println("\n\n ======= Binary Seacrh Tree Statistics =======\n\n");
							out.println("Size     : "+ bst.getSize());
							out.println("Hieght   : "+ bst.getHeight());
							out.println("Balanced : "+ bst.getBalance() + "%");
							out.println("Insertion Time : "+ time);
						}
						else if(avlB){
							out.println("\n\n ======= AVLTree Statistics =======\n\n");
							out.println("Size     :  " + avltree.getSize());
							out.println("Height   :  " + avltree.getHeight());
							out.println("Balanced :  " + avltree.getBalance() + "%");
							out.println("Insertion Time : "+ time + "seconds\n");
						}
						else{
							out.println("\n\n ======= B-Tree Statistics =======\n\n");
							out.println("Size     : "+ btree.getSize());
							out.println("Hieght   : "+ btree.getHeight());
							out.println("Order    : "+ btree.order);
							// not been able to build this logic
							//out.println("Balanced : "+ btree.getBalance());
							out.println("Insertion Time : "+ time+ "seconds\n");
						}
						System.out.println("\n ======= Statistics have been Saved ! =======\n");
							
						out.close();
					}
					// user input : "n"
					else if(in.equals("n")){}
					else
						System.out.println("Invalid Input !");
				}
				catch(Exception e)
				{
					System.out.println(e.toString());
				}
			}
			else{
				System.out.println("Usage: {-i / (-p <bst/btree/avltree> <filename> )}");
				System.out.println("-i   : Interactive Mode");
				System.out.println("-p   : Profiler Mode");
			}		
		}
		catch(Exception e){
			System.out.println("Usage: {-i / (-p <bst/btree/avltree> <filename> )}");
			System.out.println("-i   : Interactive Mode");
			System.out.println("-p   : Profiler Mode");
		}
	}
	
	public int Menu()
	{
		Scanner scan = new Scanner(System.in);
		String check = "-1";
		int choice = -1; // for handling Non Integer inputs
		boolean input = false;
		do{
			System.out.println("\n(1) - Load New Data");
			System.out.println("(2) - Tree Find");
			System.out.println("(3) - Tree Insert");
			System.out.println("(4) - Tree Delete");
			System.out.println("(5) - Tree Statistics");
			System.out.println("(6) - Save Tree");
			System.out.printf("(0) - Quit\n>>");
			check = scan.nextLine();
			// For Non Integer Input
			try{			
				choice = Integer.parseInt(check);
				if(choice >=0 && choice <=6)
					input = true;
				else{
					input = false;
					System.out.println("Invalid Input ! Please Try Agian.");
				}
			}
			catch(Exception e){
				System.out.println("Invalid Input ! Please Try Agian.");
				input = false;	
			}
		}while ( !(input) );
		return choice;
	}
}
