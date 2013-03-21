AKParallax-Android 
================

AKParallax-Android  is a Library Project that provide a parallax effect to a imageView in a ParallaxScrollView.

## Usage

### In your code

Setting the imageView that will do the parallax effect:

``` java
  protected void onCreate(Bundle savedInstanceState) {

		parallax.setImageViewToParallax(imageView);

	}
```
Setting zoom ratio of the parallax and getting the sizes of the view:

``` java
  @Override
	public void onWindowFocusChanged(boolean hasFocus) {

		super.onWindowFocusChanged(hasFocus);

		parallax.setViewsBounds(parallax.NO_ZOOM);

	}
```
