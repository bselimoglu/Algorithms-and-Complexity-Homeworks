# Algorithms-and-Complexity-Homeworks
According to homework rules, main classes and files of the homeworks are named with bilgin selimoglu and homework number

# HW1

The purpose of this homework is sort the given students ID’s, ages, administration years which we don’t know how many students are there. Also take the path of student’s data which will be inside a text file from user.

Algorithm;

   I created three classes which are called separately Student, StudentBase and Bilgin_Selimoglu_HW1. Bilgin_Selimoglu_HW1 class reads the file path which is written by user from console screen until the entered path is correct. To ensure the requirement, I used do-while loop and inside it try-catch. If path is correct then first line of file reads and the number of students sends to StudentBase class with creating a new object belong to this class. After that if next line exists, line splits according to whitespace and then every students data is named id, name, surname, age and year after that these data send the StudentBase class, creating new object that belongs student class with method addStudent and also with order of line the student. In thıs class lastly, ID’s, ages and years sorted in the StudentBase with methods of sort_ID, sort_Age, and sort_Year. 
In Student class, there are one constructor (Student) and one method. The constructor contains student’s ID, age, name, surname and admYear and I used “this” variable to refere ID, age, name, surname and admYear. toString() method is generated public and String type, it returns the student’s data to print on the console screen. 
In StudentBase class, constructor StudentBase takes number of students from main method and send the number to make array size. After that, there are bubbleSort methods that return the sorted data order. Sort_ID, sort_Age, and sort_Year methods use bubbleSort methods to print on the console screen. To do that, use addStudent method which matching the student and order of it. After matching student’s necessary data sorted and then with returned order student’s all data print on the console screen and other sorted data will print on the console screen.

Complexities;

 In Bilgin_Selimoglu_HW1 class, there is a for loop and its complexity O (n). In StudentBase class there is a for loop and inside it there is one more for loop to sort the numbers (bubbleSort) and its complexity O (n2).

# HW2

 The purpose of this homework is create an inventory database using linked list structure implemented interface which is called InventoryInterface to Inventory class which contains some add, delete and print inventory methods.

Algorithm;

I created four classes which are called separately Device, Inventory and Bilgin_selimoglu_hw2 and an interface called InventoryInterface. Device class gives from instructor Name, Type, Value and Count to create Inventory database. “yazdır” method gives the device properties to printInventory method. getName, getValue, getType and getCnt give the necessary information about device. setCnt and delCnt arrange the device information with deleting or adding. Bilgin_selimoglu_hw2 class gives the necessary command to Inventory class and it contains main method. InventoryInterface interface contains delete, add and print methods that will be used in Inventory class. Inventory class contains all interface methods. Because InventoryInterface is implemented on it. After, Node class was created inside the Inventory class to define next that is Node type and element that is Device type variables. The next variable is equaled inside constructor of Node class. The other variables or pointers which are called front and end are equaled to null inside of Inventory. element is defined Device type inside Node class because it is connection Node and Device type. After declaring IsEmpty method which is public Boolean, we can check list empty or not. To do that we look the front, is equals null or not. 

If the front does not equal to null, it means the list is not empty. Adding methods (addResistor, addCapacitor, addInductor, addTransistor) contain boolean IsAdd, Node yeni, Device ndevice also IsEmpty and setCnt (Device method’s). If list is not empty, it looks other device on the list unless IsAdd not false. To do that while loop is used. Inside it 

•	If necessary device name is after came on the list(order of devices when printing them) and this device is not end of the list then new device is added in front of the necessary device(checking device on the list). This statement used for add the new device in front of the list if the device is not single device on the list.

•	If necessary device properties are equal to the new device properties then adding method add new device that position of the list. This devices same between each other and setCnt increase the amount of device.

•	If necessary device name is equal to new device name and position is last of the list and properties are not equal then device will be last element of the list.

•	If necessary device name is not equal to new device name and the position is last of the list and the new device is have to come before the necessary device then it is added in front of the necessary device. It will be front of the list.

•	If the loop came on the last device on the list then new device is added end of the list.

•	If necessary device name comes after the new device then new device is added after the necessary device.

Deleting methods (deleteResistor, deleteCapacitor, deleteInductor, deleteTransistor) contain Node yenii, Device nndevice, Node pointer which is equal to front et the beginning, Integer remain to return device number on the inventory database, IsEmpty method to check emptiness and last delCnt method to decrease the number of device. If list is not empty and pointer does not show null, new device and and pointer element are checked they are same or not. When they are same delCnt arranges the amount of device. delCnt returns with Boolean type and it is initialize with Boolean IsPosorzero. After with getCnt, remain takes number of device. If number does not decrease, remain will be 0. printInventory method prints out devices on the list with respect to wanted order.

Complexities;

In inventory class, devices of list are printed out with respect to wanted order with O (n). Print, delete and add methods have O (n) complexity. Biggest complexity is O (n). Other classes have constant complexity O (1).

# HW3

 The purpose of this homework is find a path which was defined 1 to 32, using a stack structure implemented interface which is called HW3MAZE to a class which contains some read, solve and print methods.

Algorithm;

 To find the path of maze, 6 class was used. Bilgin_Selimoglu_HW3 class calls ReadMazeFromFile, SolveMaze and PrintSolution methods that is included in RatMaze class. In RatMaze class, 2D “maze” array, number of lines (m) and an object(path) which elements of ArrayStack class is created. Object’s type is Position. In ReadMazeFromFile method, path of maze asked from user. After got it, LineNumberReader gets the number of lines in the file to define the maze dimension. To find path, crossing roads are renumbered to 0. In SolveMaze method, around of maze numbered to 0.There are 8 different possible directions which N, S, E, W, NE, NW, SE, SW. These directions that have row and column value, in the Position class. From first position to last one every positions are tried to find next number of current path’s number. Unless number is 33 and GOBACK Boolean type false, the path is searched in the maze. If searching number is 0 then, 1 was always searched. If 1 is found, next numbers are searched. Unless next number is found present number is never pushed. If next number weren’t found previous number is popped. If the looking number 32 then immediately number is pushed and number is renumbered to 33. If 1 is pushed and 3 is searching, if it isn’t found 1’s position is popped and looking another 2 around it. 2 is not found program tries again popped from stack but ArrayStack is empty and it throw EmptyStackException exception. The try catch in the condition statement is caused to program to look for another 1 in the maze. This algorithm is valid other numbers. In PrintSolution, the all array stack popped and recording another array, which elements are position, to print positions of path respectively. 
The ArrayStack class implemets the StackInterface interface. These are Anytype class and interface. The StackInterface have some methods to get size of stack, check stack empty or not, look and get top element of stack, and put an element to top of stack. isEmpty method is used in peek and pop methods to check the stack is empty or not. The push method put the element to top of stack. The stack must have necessary space to push any item. To do that DEFAULT_CAPACITY gets value from RatMaze class in constructor of ArrayStack class. And do this value data array capacity.

Complexities;

 In RatMaze class, ReadMazeFromFile method is has biggest O (n2) complexity because of two for loops. to print the maze. SolveMaze method is has O (n) complexity. PrintSolution method is has O (n) complexity.

# HW4
 The purpose of this homework is create a hash table which size is between 500 and 550 to store words in the text file with using chaining structure when the collision happens. To do operations with hash table some methods are given in an interface which is called HW4_Interface to a class which contains build hash, convert words to integer, find a key, insert, display, check, get the number , show the maximum repetitive, sort the words methods.

Algorithm;

To store and do operation on words, 3 class and 1 interface was used. Bilgin_Selimoglu_HW4 class:

•	Gets the file name or path of text file in the project folder and the size of hash table until they’re true.

•	Create an object from cHash class, with this object BuildHash method builds hash table, and a while loop begins to get a command what user want to do until user wants to quit.

In this class, if user gives the path of text file, then filename is received with “.getName();” and gives the name to BuidHash method. Also try-catch structures are used for number format and file not found exceptions.

In cHash class, after HW4_Interface is implemented Node class was created inside the cHash class to indicate that elements of hash array consist of Node type element. Linked list structure is used to resolve the collision. In Node class, next is Node type and word is Words type variables. Words is another class which contains objects that words of the text file.  hashTable array which type is Node, stores the word in it according to key of words. Integer size is hash table size and size2 stores the amount of different words in the text file. When a new word is added, size2 is increased by one. The methods of this cHash class:

**•	void BuildHash(String filename, int size);**
when filename and size are sent to this method, content of all file is received with FileInputStream class. This class is used for reading byte-oriented data. Byte size is defined with the text file length. fileContent string stores the content of file and then this string is separated according to necessary character. Separated words are put in a String array. In a for loop every element of array and their index are sent to InsertHash.

**•	void InsertHash(String mystring,int order);**
before insert the word to hash table their key must be found. After key is determined, new Node and Words object is created according to words data and word is put to the node. A pointer node gets the hash table element in the found key index, and check respectively if this place is empty, then Node inserted here and new word number is increased, if it is not empty, then in a while loop, if same word is exist then word is updated, if not and it’s end of the linked list then last element of this linked list is connected new Node and new word size is increased. Else pointer move the next node of linked list.

**•	long ConvertInt(String mystring);**
method processes four bytes of word at a time and interpret each of the four-byte pieces individually long integer value. Every character is multiplied according power of 256 from 1 to 4. The integer values for single four-bytes are added together and sum is returned.

**•	int FindHash(long myvalue);**
method get modulus of  absolute myvalue because array index can not take negative value, and end of method key is returned.

**•	void Display(String Outputfile);**
in the hash table each words are put an array which type is Node and called sirala . FileWriter and BufferedWriter classes are used to write the words’ data in a text file which name is received from user. And to write words data to console, a nested two loops is used. For loop looks every element in the hash table and while loop prints the linked list’s words on console.

**•	int NumofWord(String myword);**
method gets key value of myword with using ConvertInt and FindHash methods and a pointer checks the number of word in the hash table if it is found, then its number is returned. If not -1 is returned.

**•	String ShowMax();**
method gives the most repeated word with using again a nested two loops. A dummy variable is created to store the most repeated one while searching the maximum value.

**•	Int[ ] CheckWord(String myword);**
method again gets the key of myword and in a while loop to find the equal word in the linked list, myword is used. If it is found an int array is returned to see every position of word in the text file. If it is not found, an array is returned which first element is -1.

**•	void Sort(String Outfile);**
method creates a new Node array again but this time its size is number of different words. Two for loops get the words of hash table and words are put the Node array, and array is sent to bubbleSort method. After it is sorted, given output file name by the user, is used to write the words and their data in a text file. Same classes are used in the Display method to write the words.  Also to write the data on console, a for loop is used inside it there is a method from Words class which is yazdır().

**•	Node [ ] bubbleSort(Node[ ] data1);**
gets the array to sort  according to words’ amount.
In Words class, for every word in the hash table there are variables such that string, amount, order array and for order array ’arrayindex’ variable. Construct of this class creates an array, to hold the order of words in the text file and synchronizes incoming data with the object variables. Each new created word has amount 1 and arrayindex 0. In void updateword(int norder) method, existing word data are updated. This update consists of increasing amount and put incoming order necessary arrayindex value in the order array. void yazdir() method prints the according word data on console.
HW4_Interface methods are used in cHash class.

Complexities;

In cHash class, BuildHash method has for loop which is O (n) complexity, InsertHash method has biggest O ( ) complexity because of two for loops for ConvertInt and also insert the word hash table, ConvertInt method has biggest O ( ), FindHash method has O(1) complexity, Display method has biggest O ( ) complexity because of three nested two loops, NumofWord method has O(n) complexity, Showmax method has O ( ) complexity, Checkword method has O(n) complexity, Sort method has        O ( ) complexity because of two nested two loops and bubleSort method has O ( ) complexity.

# Environment
I used NetBeans IDE 8.2 version to write and compile the code for all homeworks.
