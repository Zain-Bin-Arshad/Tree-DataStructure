# Tree-DataStructure-Comparison
You have learned about **Tree data structure**. Now, you will be guessing that there are various tree available, what is the benefit of one on other, which tree is fast on the given data set. Well, this project will answer all of your confusions. We will be talking about the three famous trees:

1. Binary Search Tree (BST)
2. AVl Tree
3. Btree

## How to run?
Just compile everything using `javac *.java`. Now run the file **TreeProfiler.java**.
![start](https://user-images.githubusercontent.com/49767636/83349779-da18f000-a350-11ea-8ce8-08b861099b0c.jpg)

As you can see there are two modes, I ma going to explain both don't worry mate. If you are worrying about entering some invalid data or choosing invalid option, then, my code will help you. I have done **Exception handling** to a very far extent.

## Interactive Mode
In this mode you can control the program flow, get what you need whenever you need. I am using BST by default in the interactive mode, but you can change it easily in the code. Interactive mode looks like this:
![int](https://user-images.githubusercontent.com/49767636/83349934-d2a61680-a351-11ea-9844-1970e241de41.jpg)

### Load New Data
As the name says, if you want to built a tree you have to use this option. This further gives you two more options:
![load](https://user-images.githubusercontent.com/49767636/83349981-29135500-a352-11ea-8068-cd1c6315deae.jpg)

#### Stock
Stock data means the data inside the **data.txt** file. This data actually reflects an account data and is in this format:

> Ticker, Date, Open, High, Low, Close and Volume

![stock](https://user-images.githubusercontent.com/49767636/83350020-77c0ef00-a352-11ea-926e-61f16f518d16.jpg)

If you want to play with the input data, you have to change the **AccountData.java** file and data reading code in **TreeProfiler.java**

#### Saved
Lets say you have loaded a tree and made some changes into the tree, afterwards you saved the tree. If you want to use that saved tree you can use this option.

![ved](https://user-images.githubusercontent.com/49767636/83350104-27965c80-a353-11ea-96a6-c4b165965778.jpg)

### Tree Find
If you want to find a specific key in the tree, you can make use of this option. Isn't this all trees about ? Save, retrieve huh ?
![find](https://user-images.githubusercontent.com/49767636/83350140-7512c980-a353-11ea-8727-ad55dee1c53b.jpg)

### Tree Insert
Want to insert a new value in the tree? Well you can using this option.

![insert](https://user-images.githubusercontent.com/49767636/83350244-4cd79a80-a354-11ea-9640-343a9347eb60.jpg)

Let's check whether the value got inserted or not. It's inserted!

![found](https://user-images.githubusercontent.com/49767636/83350268-85777400-a354-11ea-974a-452f73670db0.jpg)

### Tree Delete
Want to delete that unwanted node, go with this option.

![delete](https://user-images.githubusercontent.com/49767636/83350354-f9b21780-a354-11ea-9d1d-d365faf45fb3.jpg)

Check whether "ABC123" got deleted or program is messing with us. Well, it's deleted !

![del check](https://user-images.githubusercontent.com/49767636/83350370-0df61480-a355-11ea-97d9-35f31186c3df.jpg)

### Tree Statistics
Here comes the main feature, you want to know how good your tree performed? and want to save the result in a text file for later contrast and comparison? 

- How much time it took to build the tree?
- What is the size of you tree?
- What is the height of your tree?
- How much percent your tree is balanced?

Wait no more... Just want to remind that as we are using BST in interactive mode, which is an unbalanced tree. Hence, the balance % will be 0.

![stsa](https://user-images.githubusercontent.com/49767636/83350529-231f7300-a356-11ea-8339-b6e2298abb1d.jpg)

This is how **BST_stats.txt**

![bst st](https://user-images.githubusercontent.com/49767636/83350552-434f3200-a356-11ea-961f-f707be2314d1.jpg)

### Save Tree
After making some great changes to the tree, you want to save it for later use. Well, you have this option also. The tree object will be saved as a serialized object.

![saved](https://user-images.githubusercontent.com/49767636/83350629-d6886780-a356-11ea-939a-a8015df2c512.jpg)

### Quit
Mastered Tree data structure in java and want to quit? This option is for you then.
 
## Profiler Mode
In this mode you can compare the performance of a tree automatically, results will be stored in a text file for comparison if user wants. You have to specify the input data filename and tree type as a command line argument.

![simu](https://user-images.githubusercontent.com/49767636/83351350-86140880-a35c-11ea-8a05-0b7a84efac81.jpg)

Similarly, you can compare the performance by using different tree and data structure. The "AVL_stats.txt" will look like this:

![avl](https://user-images.githubusercontent.com/49767636/83351353-8b715300-a35c-11ea-9a84-c18499f209ee.jpg)

## Thanks
I would like to thank my teacher **Sir Nadeem Ghafoor Chuadhary**, for every impact he had in my life, let it be "Programming", "Ideological", "Personal" many more.
