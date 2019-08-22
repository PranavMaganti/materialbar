# Material Bar
A Material designed search bar for android written in Kotlin

[![](https://jitpack.io/v/vanpra/materialbar.svg)](https://jitpack.io/#vanpra/materialbar)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/53d0a2339a77489b83a42478f516b9ea)](https://app.codacy.com/app/pranav.maganti/materialbar?utm_source=github.com&utm_medium=referral&utm_content=vanpra/materialbar&utm_campaign=Badge_Grade_Dashboard)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Gradle Dependency
Add the following code to your root build.gradle at the end of repositories:

	allprojects {
	    repositories {
		...
		maven { url 'https://jitpack.io' }
	    }
	}

Then add the following to your project dependencies:

	dependencies {
	    implementation 'com.github.vanpra:materialbar:0.0.2'
	}

## Screenshots

| ![Material Bar](https://i.ibb.co/5hrqpv9/Screenshot-20190821-130222.png) | ![Search bar](https://i.ibb.co/qncK5fn/Screenshot-20190821-130249.png) |
| ------------------------------------------------------------------------ | ---------------------------------------------------------------------- |

## Main Bar
Material bar consists of 2 components the main bar and the search bar. The main bar can be used on its own if the search bar is not needed. The following code should be added to the main layout:

      <com.vanpra.materialbar.ui.MaterialBar  
		  android:id="@+id/bar"  
		  android:layout_width="match_parent"  
		  android:layout_height="wrap_content"  
		  android:layout_marginStart="8dp"  
		  android:layout_marginEnd="8dp"  
		  app:right_icon="@drawable/account_circle_outline"  
		  app:left_icon="@drawable/menu"
		  app:title="Mateiral Bar" />
		  
The `app:right_icon` and `app:left_icon` tags are used to set the right and left drawable's of the material bar respectively.
The `app:title` tag is used to set the text shown in the centre of the material bar.
The tags mentioned above are optional and the bar is still functional without them.

The right icon and left icon drawables along with the title can also be set programmatically from the main activity using the following code:

    bar.apply {
	    rightIcon = R.drawable.account_circle_outline
	    leftIcon  = R.drawable.menu
	    title = "Material Bar"
	    ...
    }

The listeners for the right and left icons can be set using the following code in the activity:

    bar.apply {
	    ...
	    rightIconListener = {
		    //INSERT CODE TO BE EXECUTED ON RIGHT ICON CLICK
	    }
	    
	    leftIconListener = {
		    //INSERT CODE TO BE EXECUTED ON LEFT ICON CLICK
	    }
	    ...
    }

A listener for the bar itself can also be set using the following code:

    bar.apply {
	    ...
	    barClickListener = {
		    //INSERT CODE TO BE EXECUTED BAR CLICK
	    }
    }
 ## Search Bar
To use the search bar a new activity (SearchActivity) should be created and the following code should be added to the activity xml:

     <com.vanpra.materialbar.ui.SearchBar  
	      android:id="@+id/searchBar"  
	      android:layout_width="match_parent"  
	      android:layout_height="match_parent"  
	      app:search_hint="Search for a song, artist or album" />

The `app:search_hint` is used to set the hint text in the search bar.

The search bar automatically stores any searches made in a room database and displays the recent searches page when there is no text in the search bar.

In the main activity in which the material bar has been defined the setBarClickListener should include the following code:

    bar.apply {
	...
		barClickListener =  {
			val intent = Intent(this, SearchActivity::class.java)   
			startActivity(intent)
		}
    }

The search bar requires an RecyclerView Adaptor to display the results of the search:

    val customAdapter = CustomRecyclerViewAdapter()
    
    searchBar.apply {
		searchResultsAdapter = customAdapter
			
		backListener = {  
			finish()  
		}

		textListener = { searchText ->
			//DO SOMETHING WITH SEARCH TEXT
		}
    }
   
 The `backListener` is used to set a listener for the back icon shown in the search bar. Usually this icon will finish the search activity and return the user to the main activity as shown in the code above.
The `textListener` is used to set a listener for the text which the user types into the search bar. The listener should filter the list of all results depending on the `searchText` which is returned to the listener. The filtered list of results should then be submitted to the custom recyclerview adaptor which will update the search results.
