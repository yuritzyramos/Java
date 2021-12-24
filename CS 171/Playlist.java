/* THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS
 OR COPIED FROM ONLINE RESOURCES. Yuritzy Ramos */

public class Playlist
{
   private Episode head;
   private int size;

   public Playlist()
   {
      head = null;
      size = 0;
   }

   public boolean isEmpty()
   { return head == null; }

   // Please ensure that "size" is updated properly in other methods, to
   // always reflect the correct number of episodes in the current playlist
   public int getSize()
   { return this.size; }

   // Displays the Episodes starting from the head and moving forward
   public void displayPlaylistForward()
   {
     String output = "[BEGIN] ";
     Episode current = head;
     if( current != null ){
       while(current.next != head ){
         output += current + " -> ";
         current = current.next;
       }
       output += current + " [END]\n";
     }
     else{
       output += " [END]\n";
     }
     System.out.println(output);
   }

   // Displays the Episodes starting from the end and moving backwards
   public void displayPlaylistBackward() 
   {
    String output = "[END] "; //Labels the end of the cirrcular doubly linked list

    Episode current = head;//Assigns head reference to a new node current

    if(current != null){//if the current node does not equal null
      while(current.prev != head){//While the previous pointer of the current
                                      //node does not point to head (the first node)
      current = current.prev;//Make the current node equal the previous node
      output += current + " -> "; //Add current to the output 
      }
      current = current.prev;//Retrieves the Episode stored in first node
      output += current + " [BEGIN]";//Add the current node to the output plus
                                        //the [BEGIN] label
    }else{
      output += " [BEGIN]";//if the list is empty add the [BEGIN] label
    }
    System.out.println(output);//Print the output onto the user's screen 
          }

   // Adds a new Episode at the beginning of the Playlist
   public void addFirst( String title, double length )
   {
    if(isEmpty()){//If the list is empty 
    
     Episode node = new Episode(title, length, head, head);// Creates a new node whose next and previous 
                                                              //pointers reference head 
     head = node;//Assigns node as the head of the list   
     head.prev = head;//The head.prev pointer points to head
     head.next = head;//The head.next pointer points to head
     size++;//Update size 
  
      }else{// if the list is not empty
      
      Episode findLast = head;//Assigns head to findLast node this will be
                                //used to have a reference to the last node  
      if(findLast != null){// If the findLast node does not equal null
        
        if(getSize() == 1){//If the size of the list is 1
          
        head.prev = head;//The head.prev pointer references head
        head.next = head;//The head.next pointer references head
        }

      while(findLast.next != head){//While the findLast pointer does not equal head
         
        findLast = findLast.next;//The findLast node equals the node referenced 
                                    //by the findLast.next pointer
        }
        Episode node = new Episode(title, length, head, findLast);//Creates a new node with inputed title and length whose next 
                                                            //pointer references head and the previous pointer references the last node
        findLast.next = node;//The last node's pointer references the new node
        head.prev = node;//The head.prev pointer points to node
        head = node;//Head equals node (node is now the first item of the list)
        size++;//Update size  by 1
       }
    }
}

  // Adds a new Episode at the end of the Playlist
   public void addLast(String title, double length){

    if(isEmpty()){//If the list is empty

      addFirst(title, length);//Add a node to the beginning of the list 
                            //with inputed title and length
    }else{

      Episode findLast = head;//Assigns head to findLast node this will be
                          //used to have a reference to the last node  
    if(findLast != null){//If the findLast node does not equal node

    if(getSize() == 1){//If the size of the list is 1
    head.prev = head;//The head.prev pointer references head
    head.next = head;//The head.next pointer references head
    } 
   
    while(findLast.next != head){//While the findLast pointer does not equal head
    findLast = findLast.next;//The findLast node equals the node referenced 
                                    //by the findLast.next pointer
   }
   
      Episode node = new Episode(title, length, head, findLast);////Creates a new node with inputed title and length whose next 
                                              //pointer references head and the previous pointer references the last node
        findLast.next = node;//The last node's pointer references the new node
        head.prev = node;//The head.prev pointer points to node
        size++;//Update size by 1
    }
  }
}

   // Add a new Episode at the given index, assuming that index
   // zero corresponds to the first node
   public void add( String title, double length, int index )
   {

    if(index == 0){//If the inputed index is 0

      addFirst(title, length);//Add node with inputed title and length at the beginning of linked list

   }else if(index == getSize()){//If the inputed index is the size of the list
      addLast(title, length);//Add node with inputed title and length to the end if the linked list

   }else if(index > (getSize()-1)){//Else if the inputed index is greater than the 
                                     //size of the linked list (accounts for indices starting at 0)

      throw new IndexOutOfBoundsException();//Throw IndexOutOfBoundsException error

   }else{
      Episode current = head;//Initializes a node "current" with a reference to head 
      Episode nextNode = current.next;//Assigns the reference of the node after current to nextNode
      
      int i = 0;//Initializes i at 0 (0th index representing the first element)

    while(i < (index-1)){//While i is less than the inputed index
                            //Subtract one from the inputed index because indexes start at 0

        current = nextNode;//current equals nextNode (the next node in the linked list)
        nextNode = nextNode.next;//nextNode equals the next node in the linked list (one ahead of current)
        i++;//Update i 

    }
      Episode newNode = new Episode(title, length, nextNode, current);//Creates a new node whose next pointer points to nextNode
                                                                          //and the previous pointer points to current
        current.next = newNode;//current.next point to newNode
        nextNode.prev = newNode;//nextNode.prev points to newNode
        size++;//Update size by 1
  }
}

   // Delete the Episode that has the given "title"
   // You can assume there will be no duplicate titles in any Playlist
   public Episode deleteEpisode(String title)
   {
    
    Episode tracker = head;//Initializes a node "tracker" with a reference to head 
                              //It will be used to store a reference to the deleted node

    if(isEmpty()) throw new RuntimeException("An error occurred:Cannot delete from empty list!");
    //If the list is empty throw an exception message
   
    if(head.getTitle().equals(title)){//If head has the inputed title
      
      if(getSize() == 1){ //Check if there is only one Episode in the playlist
                            //If this statement is true
         tracker = head;//Tracker now holds a reference to head
          head.next = null;//This makes the head.next pointer point to null
          head = head.next;//Head equals head.next (which now equals node instead of head)
                            //This deletes the episode from the list
          size--;//Update size
      }
      
      //If the size of the linked list isn't 1 then...
      Episode temp = head;///Initializes a node "temp" with a reference to head 

      if(temp != null){//If temp equals null

        while(temp.next != head){//While the temp.next pointer does not equal head
          temp = temp.next;//temp equals the next node in the linked list
        }

        //Once temp.next equals head
          tracker = head;//Assigns a reference to head in temp
          head = head.next;//Head now equals the next node in the linked list
          head.prev = temp;//head.prev points to temp (the last node in the linked list)
          temp.next = head;//temp.next points to the new head 
          size--;//Update head by minus 1
      }

    }else{//If the inputed title isn't held in head
    
      Episode currentEpisode = head;//Initializes a node "currentEpisode" with a reference to head 
     
    if(currentEpisode != null){//If currenEpisode does not equal null

     while(currentEpisode.getTitle() != title){//While the title of currentEpisode does not equal the inputed title
        
        currentEpisode = currentEpisode.next;//currentEpisode equals currentEpisode.next (the next episode in the playlist)
        tracker = currentEpisode;//tracker stores a reference to currentEpisode
      

        if(currentEpisode == head) throw new RuntimeException("Item cannot be deleted: It does not exist in the playlist!");
      //If currentEpisode equals head (every epsiode in the linked list has been transversed & the inputed title was not found)
          //return an error message to the user
       }

        //When the title of currentEpisode does equal the inputed title..
        currentEpisode.prev.next = currentEpisode.next;//currentEpisode.prev (pointer of the previous node) points to currentEpisode.next (pointer of the next node)
        currentEpisode.next.prev = currentEpisode.prev;//currentEpisode.next (pointer of the next node) points to currentEpisode.prev (pointer of the previous node)
        size--;//Update size minus 1
      }
    
    }
    return tracker;//Return the deleted episode to the user 
}

// Delete every m-th Episode in the user's circular Playlist,
// until only one Episode survives. Return the survived Episode.
public Episode deleteEveryMthEpisode(int m)
   {

  Episode tracker = head;//Initializes a node "tracker" with a reference to head; will store reference of surviving node

if(getSize() == 0){//If the size of the linked list is 0
  
  throw new RuntimeException("An error occurred: Cannot delete from empty list!");//Throw an exception message

}else if (m == 0){//If the inputed number equals 0
 
  throw new RuntimeException("An error occurred: Inputed # must be greater than 0");//Throw an exception message

}else if(size == 1){//else if the size of the linked list is 1

tracker = head;//tracker equals head 

}else if(m == 1){//else if the inputed number is 1 (every episode except the last one is deleted)

  Episode lastEpisode = head;//Initializes a node "lastEpisode" with a reference to head

  if(lastEpisode != null){//If lastEpisode does not equal null
        
  while(lastEpisode.next != head){//While the lastEpisode.next pointer does not equal head 
  
    lastEpisode = lastEpisode.next;//lastEpisode equals the next node in the linked list
        }

    tracker = lastEpisode;//tracker stores a reference to lastEpisode
    lastEpisode.next = lastEpisode;//The lastEpisode.next pointer points to lastEpisode
    lastEpisode.prev = lastEpisode;//The lastEpisode.prev pointer points to lastEpisode
    head = lastEpisode;//lastEpisode becomes the head of the linked list
    size = 1;//Updates size of list to 1 episode 
 }
}

else{//Otherwise...

  Episode mthNode = head;//Initializes a node "mthNode" with a reference to head; will store a reference 
                        //to the every mth node of the linked list

while(getSize() > 1){//While the size of the list is not 1

  int i = 0;//Initialize a variable i of type int to 0 

while(i != (m-1)){//While i does not equal m-1 (accounts from indices starting at 0)

  mthNode = mthNode.next;//mthNode equals the next node in the linked list
  i++;//Increase i by 1

}
  deleteEpisode(mthNode.getTitle());//Deletes the epsiode in the playlist with the title of the mthNode
  mthNode = mthNode.next;//Moves mthNode one node forward (accounts for the fact that the original mthNode was deleted)
                          //This ensures that the correct episode is deleted in the next iteration
}

if(getSize() == 1){//if the size of the linked list equals 1...
  head = mthNode.next;//Make the surviving node the head of the list
  tracker = mthNode.next;//Store the surviving node in tracker
}

    }
return tracker;//Return surviving node to user
  }
}
// End of Playlist class