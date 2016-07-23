//
//  GenericList.h
//  Final_Practice
//
//  Created by Adish Betawar on 5/13/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//


//This is the header file genericlist.h. This is the interface for the
//class GenericList. Objects of type GenericList can be a list of items
//of any type for which the operators << and = are defined.
//All the items on any one list must be of the same type. A list that
//can hold up to max items all of type Type_Name is declared as follows:
//GenericList<Type_Name> the_object(max);
#ifndef GENERICLIST_H
#define GENERICLIST_H
#include <iostream>
using namespace std;

template<class ItemType>
class GenericList
{
private:
    ItemType *item; //pointer to the dynamic array that holds the list.
    int max_length; //max number of items allowed on the list.
    int current_length; //number of items currently on the list.
    int currentItem; // current item index location
public:
    GenericList(int max);
    //Initializes the object to an empty list that can hold up to
    //max items of type ItemType.
    ~GenericList( );
    //Returns all the dynamic memory used by the object to the freestore.
    
    int length() const;
    //Returns the number of items on the list.
    
    void add(ItemType new_item);
    //Precondition: The list is not full.
    //Postcondition: The new_item has been added to the list.
    bool full() const;
    //Returns true if the list is full.
    
    void erase();
    //Removes all items from the list so that the list is empty.s
    
    ItemType CurrentValue(); // accessor for current value
    const void MoveNext(); // makes next item the current value
    const void MoveBack(); // makes the previous value the current value
    const void Top(); // makes the first item the current item
    const void Last(); // makes the last item the current item
    ItemType ReturnItemAt(int index); // makes the nth item the current item
    int CurrentItem()
    {
        return currentItem;
    }
    
    bool CheckIfBottom()
    {
        if (currentItem == current_length - 1)
            return true;
        return false;
    };
    
    friend ostream& operator << (ostream& outs, const GenericList<ItemType>& the_list)
    {
//        for (the_list.Top(); the_list.CheckIfBottom() == false; the_list.MoveNext())
//        {
//            outs << the_list.CurrentItem() << " ";
//        }
        
        for (int i = 0; i < the_list.current_length; i++) outs << the_list.item[i] << endl;
        return outs;
    }
    
    //Overloads the << operator so it can be used to output the
    //contents of the list. The items are output one per line.
    //Precondition: If outs is a file output stream, then outs has
    //already been connected to a file.
    //
    //Note the implementation of the overloaded << in the header
    //file! This is commonly done with overloaded friend templates.
    //Since << is a friend it is NOT a member of the class but
    //rather in the namespace, this is the simplest implementation
    //and may make more sense than putting it in genericlist.cpp.
};




template<class ItemType>
GenericList<ItemType>::GenericList(int max) : max_length(max), current_length(0), currentItem(-1)
{
    item = new ItemType[max];
}

template<class ItemType>
GenericList<ItemType>::~GenericList( )
{
    delete [] item;
}

template<class ItemType>
int GenericList<ItemType>::length( ) const
{
    return (current_length);
}

//Uses iostream and cstdlib:
template<class ItemType>
void GenericList<ItemType>::add(ItemType new_item)
{
    if (full())
    {
        cout << "Error: adding to a full list.\n";
        exit(1);
    }
    else {
        item[current_length] = new_item;
        current_length = current_length + 1;
    }
}

template<class ItemType>
bool GenericList<ItemType>::full( ) const
{
    return (current_length == max_length);
}

template<class ItemType>
void GenericList<ItemType>::erase( )
{
    current_length = 0;
}



template<class Itemtype>
Itemtype GenericList<Itemtype>::CurrentValue()
{
    if (currentItem < 0)
        return NULL;
    if (currentItem >= current_length)
        return NULL;
    return item[currentItem];
}


template<class Itemtype>
const void GenericList<Itemtype>::MoveNext() // makes next item the current value
{
    
    if (currentItem >= current_length)
    {
        cout << "There is nothing after this element" << endl;
    }
    else
    {
        currentItem++;
    }
}

template<class Itemtype>
const void GenericList<Itemtype>::MoveBack() // makes the previous value the current value
{
    if (currentItem <= 0)
    {
        cout << "There is nothing before this element" << endl;
    }
    else
    {
        currentItem = currentItem - 1;
    }
}

template<class Itemtype>
const void GenericList<Itemtype>::Top() // makes the first item the current item
{
    currentItem = 0;
}

template<class Itemtype>
const void GenericList<Itemtype>::Last() // makes the last item the current item
{
    currentItem = current_length - 1;
    
}

template<class Itemtype>
Itemtype GenericList<Itemtype>::ReturnItemAt(int index) // makes the nth item the current item
{
    if (currentItem < 0)
        return NULL;
    if (currentItem >= current_length)
        return NULL;
    return item[index]; // returns the value at the particular index location
}





#endif //GENERICLIST_H