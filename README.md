# JavaFX-example

_Using JavaFX to develop a program for processing data from existing files and entering the processed data into files created by Java._

<br/>
## Conditions:

#### 1. Format of existing files (planes):

N | Plane |  Speed | Distance
--- | --- | --- | ---
1 | ANT_124_Ruslan |  880 |  20.0
2 | Dream_24 | 600 | 18.0
… |... | ... | ... 

#### 2. Count of existing files – **3**

#### 3. Contents of data processing from files:

- create a file with planes at speeds less than 800,
- create a file with planes to enter aircraft at speeds within 801… 900,
- create a file with planes to enter aircraft at speeds greater than 901.

#### 4. Sort in the source files to perform three options:

- by Plane, by equality - by Speed, by equality - by Distance,
- by Speed, by equality - by Plane, by equality - by Distance,
- by Speed, by equality - by Distance, by equality - by Plane.

#### 5. Set the sort type from the drop-down list. Use the _split()_ method of the String class to convert a text string to a Strings array. Use _parseDouble()_ from the Double class and _parseInt()_ from the Integer class to convert text variables to numeric ones.


### Instructions:

#### Main menu:
<img src="main_menu.png" width="400">
<br/>
*You can choose the type of sorting from the select input*
<br/>
<img src="choose_sorting_type.png" width="400">
<br/>
*After that you can click button "Sort the files!" to run the main logic of the application. After that files will be sorted and writed in appropriate files*


