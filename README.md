AKParallax-Android 
================

AKParallax-Android  is a Library Project that provides a parallax effect to an imageView in a ScrollView or a ListView.

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AKParallax--Android-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1056)

## Sample

The sample application (the source is in the repository) has been published onto Google Play for easy access:

<a href="https://play.google.com/store/apps/details?id=com.appkraft.parallax_sample">
	<img alt="Android app on Google Play"
        src="https://developer.android.com/images/brand/en_app_rgb_wo_60.png" />
 </a>
 
## Usage

* Import the app folder as an Android project. The .project included will cause it to have the name `Parallax`.

### ScrollView

#### In your activity xml

``` xml

  <net.appkraft.parallax.ParallaxScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res/com.appkraft.parallax_sample"
    android:id="@+id/scrollView1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:overScrollMode="never"
    app:zoomRatio="1.4" >

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="1000dp"
        tools:context=".MainActivity" >

        <RelativeLayout
            android:id="@+id/relativeLayout1"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            tools:context=".MainActivity" >

            <ImageView
                android:id="@+id/imageView1"
                android:layout_width="match_parent"
                android:layout_height="100dp"
                android:src="@drawable/teste" />

            <TextView
                android:id="@+id/textView1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_alignParentBottom="true"
                android:layout_alignParentLeft="true"
                android:text="Bottom"
                android:textColor="#ffffff"
                android:textSize="18sp" />

            <TextView
                android:id="@+id/textView2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_alignParentLeft="true"
                android:layout_alignParentTop="true"
                android:text="Top"
                android:textColor="#ffffff"
                android:textSize="18sp" />
        </RelativeLayout>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentLeft="true"
            android:layout_below="@+id/relativeLayout1"
            android:text="@string/hello_world" />
    </RelativeLayout>

</net.appkraft.parallax.ParallaxScrollView>

```

#### In your code

Setting the imageView that will do the parallax effect:

``` java
  protected void onCreate(Bundle savedInstanceState) {

		parallax.setImageViewToParallax(imageView);

	}
```
Setting zoom ratio of the parallax :

``` java
  protected void onCreate(Bundle savedInstanceState) {

		parallax.setImageViewToParallax(imageView);
		parallax.setViewsBounds(1.3);

	}
```

### ListView

#### In your activity xml

``` xml

  <net.appkraft.parallax.ParallaxListView 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res/com.appkraft.parallax_sample"
    android:id="@+id/listView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:overScrollMode="never"
    app:zoomRatio="1.4" >

</net.appkraft.parallax.ParallaxListView>

```

#### In your code

Setting the imageView that will do the parallax effect:

``` java
  protected void onCreate(Bundle savedInstanceState) {

		...
		
		image = new ImageView(this);
        	image.setImageResource(R.drawable.teste);
        	AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
        	image.setLayoutParams(params);

        	parallax.addHeaderView(image);
        	parallax.setImageViewToParallax(image);

	}
```
Setting zoom ratio of the parallax :

``` java
  protected void onCreate(Bundle savedInstanceState) {
  
  		...
  
		parallax.setViewsBounds(1.3);

	}
```

## License

		The MIT License (MIT)
		
		Copyright (c) 2014 Ygor Barboza Muniz
		
		Permission is hereby granted, free of charge, to any person obtaining a copy
		of this software and associated documentation files (the "Software"), to deal
		in the Software without restriction, including without limitation the rights
		to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
		copies of the Software, and to permit persons to whom the Software is
		furnished to do so, subject to the following conditions:
		
		The above copyright notice and this permission notice shall be included in all
		copies or substantial portions of the Software.
		
		THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
		IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
		FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
		AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
		LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
		OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
		SOFTWARE.


