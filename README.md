# What is Catalog?
Catalog is a program that allows the user to navigate a catalog of songs and allows for the creating, managing, and deleting of playlists.

# How does it work?
As of right now, this program only takes in the MonstercatFull.txt file and the schema setup that it contains.
The program begins with the Main file where all of the information in the file is loaded in and then the program starts the UserInterface file.

The UserInterface.java file is a text-based compiler interaction system. The user interacts with the program itself through inputs in the compiler.

There are four base commands that the user goes through

>1. View Catalog
>2. Create a playlist
>3. Manage a playlist
>4. View a playlist

Each function does something different.

>1. View Catalog

In this function, the user is allowed to navigate the catalog and search for songs using a search system that uses keywords or the user can search for a song based on genre, release date, or even the artist.

Another feature included in this function is the Mystery Track option, which will randomly select a song in the catalog.

>2. Create a playlist

As the name says, this function allows the user to create a playlist and add songs from the catalog to it. There are no duplicate playlist names allowed.

>3. Manage a playlist

This function contains several functions that are vital to the actual playlist itself.

Firstly, the add feature. The user is able to add more songs from the catalog to the playlist.

Secondly, the remove feature. The user is able to remove songs from the playlist.

Thirdly and lastly, the delete feature, which allows for the deletion of a playlist.

>4. View a playlist

Evident by the name, this function allows the user to view all the songs in a playlist.


> exit

The program will terminate with this command.


# Why did I create this?
As evident by the text file, I was listening to Monstercat, and while I was on their website, I saw their catalog with hundreds of songs. And then there was also a playlist feature. I was curious to how it all worked, so what better way to learn than coding it yourself. 

This was also interesting to program as this was the first time I created something to this scale using OOP. I've used OOP before, but that was mainly two files with one being a runner. 
It was also cool to load in thousands of lines of data from a file into the program.

