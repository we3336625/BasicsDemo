BasicsDemo
=======
ActivityTest
----------

```Java
	|--Context
		|--ContextWrapper
			|--ContextThemeWrapper
				|--Activity
					|--AccountAuthenticatorActivity
					|--ActivityGroup	//Deprecated
						|--TabActivity	//Deprecated
					|--AliasActivity
					|--ExpandableListActivity
					|--FragmentActivity
					|--ListActivity
						|--LaucherActivity
						|--PreferenceActivity
						
```


AndroidView
----------

```
	Android中一般支持如下常用的距离单位：
		px (像素):每个px对应屏幕上的一个点。
		dip或dp (device independent pixels, 设备独立像素):一种基于屏幕密度的抽象单位。在每英寸160点的显示屏上，
										1dip = 1px。但随着屏幕密度的改变，dip 与 px 的换算会发生改变。
		sp (scaled pixels, 比例像素):主要处理字体的大小，可以根据用户的字体大小首选项进行缩放。
		in (英寸):标准长度单位。
		mm (毫米):标准长度单位。
		pt (磅):标准长度单位，1/72英寸。

-------------------------------------------------

	|--View
		|--ImageView: 用于显示图片，任何 Drawble 对象都可以使用 ImageView 来显示。
		|	|--ImageButton (图片按钮): 与 Button 的区别在于，Button 生成的按钮上显示文字，
										而 ImageButton 上则显示图片。
		|		|--ZoomButton (缩放按钮): ZoomButton 可以代表 “放大” 、“缩小” 两个按钮。
										ZoomButton 的行为基本类似于 ImageButton, 只是 Android 默认提供了 btn_minus 、
										 btn_plus, 即可实现 “缩小” 、 “放大” 按钮。
		|
		|	|--QuickContactBadge (显示关联到特定联系人的图片): QuickContactBadge 继承了 ImageView ，
									因此它的本质也是图片按钮，也可以通过 src 属性指定它显示的图片。 
									QuickContactBadge 额外增加的功能是: 该图片可以关联到手机中指定联系人，
									当用户点击该图片时，系统将会打开相应联系人的联系方式界面。
		|
		|
		|--ProgressBar (进度条): 通常用于向用户显示某个耗时操作完成的百分比。
								进度条可以动态的显示进度，因此避免长时间的执行某个耗时操作时，
								让用户感觉程序失去了响应，提高用户界面的友好性。
		|	|--AbsSeekBar
		|		|--SeekBar (拖动条): 通过滑块的位置来标识数值，允许用户拖动滑块来改变值，
								因此拖动条通常用于对系统的某种数值进行调节，如调节音量。
		|		|--RatingBar (星级评分条): 用法、功能与拖动条 SeekBar 接近：都允许用户通过拖动来改变进度。
									 区别在于： RatingBar 通过星星来表示进度。
		|
		|
		|--TextView (文本框)
		|	|--Button (按钮): Button继承了 TextView，它主要是在UI界面上生成一个按钮，该按钮可以供用户单击，
										当用户单击按钮时，按钮会触发一个 onClick 事件。
		|		|--CompoundButton
		|			|--CheckBox (复选框): 与 Button 不同的是，多了一个可选中的功能，可额外指定一个 cheched 属性，
									该属性可指定是否被选中。可选择多个。
		|			|--RadioButton (单选钮): 与 Button 不同的是，多了一个可选中的功能，可额外指定一个 cheched 属性，
							该属性可指定是否被选中。只能选择其中一个，通常要与 RadioGroup 一起使用，用于定义一组单选按钮。
		|			|--Switch (开关): 通常用于切换程序中的某种状态。
		|			|--ToggleButton (状态开关按钮): 通常用于切换程序中的某种状态。
		|
		|	|--EditText (编辑框)
		|		|--AutoCompleteTextView (自动完成的文本框): 从 EditText 派生而出，实际上它也是一个文本编辑框，
						但它比普通编辑框多了一个功能: 当用户输入一定字符之后，自动完成文本框会显示一个下拉菜单，
						供用户从中选择，当用户选择某个菜单项之后， AutoCompleteTextView 按用户选择自动填写该文本框。
						(使用时，只要设置一个 Adapter 即可，该 Adapter 封装了 AutoCompleteTextView 预设的提示文本)
		|			|--MultiAutoCompleteTextView: 功能与 AutoCompleteTextView 基本相似，
							只是 MultiAutoCompleteTextView 允许输入多个提示项，多个提示项以分隔符分割。
							MultiAutoCompleteTextView 提供了 setTokenizer() 方法来设置分隔符。
		|		|--ExtractEditText: 它不是 UI组件，而是 EditText 组件的底层服务类，负责提供全屏输入法支持。
		|
		|	|--TextClock (时钟): TextClock 本身就继承了 TextView,也就是说，他本身就是文本框，
							只是它里面显示的内容总是当前时间。与 TextView 不同的是，
							为 TextClock 设置 text 属性没什么作用。
		|	|--Chronometer (计时器): 该组件与 TextClock 都继承 TextView，因此它们都会显示一段文本。
							但 Chronometer 并不显示当前时间，它显示的是从某个起始时间开始，一共过去了多长时间。
		|	|--CheckedTextView
		|
		|
		|--AnalogClock (时钟)	//Deprecated
		|--ViewGroup
			|--AdapterView: 1.AdapterView 继承了 ViewGroup ，他的本质是容器。
								2. AdapterView 可以包括多个 “列表项”，并将多个 “列表项” 以合适的形式显示出来。
								3. AdapterView 显示的多个 “列表项” 由 Adapter 提供。
								调用 AdapterView 的 setAdapter(Adapter) 方法设置 Adapter 即可。
			|	|--AbsListView
			|		|--GridView (网格视图): 用于在界面上按 行、列 分布的方式来显示多个组件。								(如果让 GridView 只显示一列，那个该 GridView 就变成了 ListView)
			|		|--ListView (列表视图): ListView是手机系统中使用非常广泛的一种组件，它以垂直列表的形式显示所有列表项。
			|			|--ExpandableListView (可展开的列表组件): 是 ListView 的子类，
								它在普通 ListView 的基础上进行了扩展，它把应用中的列表项分为几组，
								每组里又可包含多个列表项。  用法与普通 ListView 的用法非常相似，
								只是 ExpandableListView 所显示的列表项应该由 ExpandableListAdapter 提供。
			|
			|	|--AbsSpinner
			|		|--Gallery: 显示的是一个水平列表选择框。 允许用户通过拖动来查看上一个、下一个列表项。	//Deprecated
			|		|--Spinner (列表选择框): 显示的是一个垂直列表选择框。作用是供用户选择。 
						(entries 使用数组资源设置该下拉列表框的列表项。 或使用 Adapter 为 Spinner 提供列表项。)
			|
			|	|--AdapterViewAnimator
			|		|--AdapterViewFlipper(): 它会显示 Adapter 提供的多个 View 组件，但它每次只能显示一个 View 组件，通过 showPrevious() 和 showNext() 方法控制该组件显示 上一个、下一个 组件。
			|		|--StackView: 用于显示 Adapter 提供的一系列 View。"堆叠(Stack)" 的方式显示多个列表项。 
							提供了如下两种控制方式: 
							1. 拖走 StackView 中处于顶端的 View， 下一个 View 将会显示出来。
							将上一个 View 拖进 StackView， 将使之显示出来。 
							2. 通过调用 StackView 的 showNext() 、showPrevious() 控制显示 下一个、上一个 组件。
			|
			|--AbsoluteLayout (绝对布局): 通过X坐标、Y坐标来控制组件的位置。	//Deprecated
			|--GridLayout (网格布局): 它把整个容器划分为 rows × columns 个网格，每个网格可以放置一个组件。
						除此之外，也可以设置一个组件横跨多少列、一个组件纵跨多少行 (Android 4.0新增的布局管理器)
			|--RelativeLayout (相对布局): 相对布局容器内子组件的位置总是相对兄弟组件、父容器来决定的，
						因此这种布局方式被称为相对布局
			|--FrameLayout (帧布局): 帧布局容器为每个假如其中的组件创建一个空白的区域(称为一帧)，每个子组件占据一帧，
						这些帧都会根据gravity属性执行自动对齐。
			|	|--CalendarView (日历视图)
			|	|--DatePicker (日期选择器)
			|	|--TimePicker (时间选择器)
			|	|--ScrollView (滚动视图): 一个用于为普通组件添加滚动条的组件。 ScrollView里面最多只能包含一个组件，
							ScrollView 作用就是为该组件添加垂直滚动条。
			|	|--HorizontalScrollView: 添加水平滚动条。
			|	|--TabHost (选项卡)
			|	|--ViewAnimator (可以在View切换时表现出动画效果)
			|		|--ViewFlipper: addView(View view) 添加多个组件，一旦向ViewFlipper 中添加了多个组件之后，
							ViewFlipper 就可使用动画控制多个组件之间的切换效果
			|		|--ViewSwitcher (视图切换组件): 它本身继承了 FrameLayout， 因此可以将多个 View 层叠在一起，
							每次只显示一个组件。当程序控制从一个 View 切换到另一个 View 时， 
							ViewSwitcher 支持指定动画效果。   为了给 ViewSwitcher 添加多个组件，
							一般通过调用 ViewSwitcher 的 setFactory(ViewSwitcher.ViewFactory) 
							方法为之设置 ViewFactory， 并由该 ViewFactory 为之创建 View 即可。
			|			|--ImageSwitcher (图像切换器): 具有与 ViewSwitcher 相同的特征: 
								可以再切换 View 组件时使用动画效果。 使用步骤: 1. 为 ImageSwitcher 提供一个 
								ViewFactory， 该 ViewFactory 生成的 View 组件必须是 ImageView。 
								2. 需要切换图片时，只要调用 ImageSwitcher 的 
								setImageDrawable(Drawable drawable)、 setImageResource(int resid) 和 
								setImageURI(Uri uri) 方法更新图片即可。
			|			|--TextSwitcher (文本切换器): 具有与 ViewSwitcher 相同的特征: 
								可以再切换 View 组件时使用动画效果。与 ImageSwitcher 相似的是：
								也需要设置一个 ViewFactory。 不同的是：TextSwitcher 所需的 ViewFactory 
								的 mackView() 方法必须返回一个 TextView 组件。
			|
			|--LinearLayout (线性布局): 可以控制各组件横向排列，可以控制各组件纵向排列(通过设置 orientation 属性控制)。
			|	|--TableLayout (表格布局): 采用行、列的形式来管理 UI组件，通过添加 TableRow、
							其他组件来控制表格的行数、列数。
			|	|--NumberPicker (数值选择器)
			|	|--SearchView (搜索框): 可以让用户在文本框内输入文字，并允许通过监听器监控用户输入，
							当用户输入完成后提交搜索时，也可通过监听器执行实际的搜索。
			|	|--ZoomControls (): 该组件相当于同时组合了 “放大” 、 “缩小” 两个按钮， 
							并允许分别为两个按钮绑定不同的时间监听器。
			
			
-------------------------------------------------

	|--*Adapter
		|--*ListAdapter①
			|--*WrapperListAdapter
				|--HeaderViewListAdapter
		|--*SpinnerAdapter②
			|--①&②BaseAdapter: 通常用于被扩展。扩展 BaseAdapter 可以对各列表进行最大限度的定制。
			|			getCount(): 该方法的返回值控制该 Adapter 将会包含多少个列表项。
			|			getItem(int position): 该方法的返回值决定第 position 处的列表项的内容。
			|			getItemId(int position): 该方法的返回值决定第 position 处的列表项的 ID。
			|			getView(int position, View convertView, ViewGroup parent): 
								该方法的返回值决定第position处的列表项组件。
			|
				|--SimpleAdapter: 并不简单、功能强大的 adapter，可用于将 List 集合的多个对象包装成多个列表项。
				|			new SimpleAdapter(Context context, 
								List<? extends Map<String, ?>> data, 
								@LayoutRes int resource, 
								String[] from, 
								@IdRes int[] to) 
				|
				|
				|--ArrayAdapter<T>: 简单、易用的adapter，通常用于将数组或 List 集合的多个值包装成多个列表项。
				|			new ArrayAdapter(@NonNull Context context, 
								@LayoutRes int resource, 
								@IdRes int textViewResourceId, 
								@NonNull T[] objects)
				|			new ArrayAdapter(@NonNull Context context, 
								@LayoutRes int resource, 
								@IdRes int textViewResourceId, 
								@NonNull List<T> objects)
				|
				|--CursorAdapter
					|--ResourceCursorAdapter
						|--SimpleCursorAdapter: 与 SimpleAdapter 基本相似，只是用于包装 Cursor 提供的数据。
				

-------------------------------------------------

	|--*ExpandableListAdapter
		|--BaseExpandableListAdapter
			|--SimpleExpandableListAdapter: 将两个 List 集合包装成 ExpandableListAdapter
			|--CursorTreeAdapter
				|--ResourceCursorTreeAdapter
					|--SimpleCursorTreeAdapter:  将 Cursor 中的数据包装成 SimpleCursorTreeAdapter。

-------------------------------------------------
	
	|--PopupWindow (对话框风格的窗口): 使用步骤: 1. 调用 PopupWindow 的构造器创建 PopupWindow 对象。 
				2. 调用 PopupWindow 的 showAsDropDown(View view) 将 PopupWindow 作为 view 组件的下拉组件显示出来；
				或调用 PopupWindow 的 showAtLocation() 方法将 PopupWindow 在指定位置显示出来。 
	
-------------------------------------------------

	|--Notification (状态栏的通知): 显示在手机状态栏的通知。 所代表的是一种具有全局效果的通知，
				一般通过 NotificationManager 服务来发送 Notification。
		NotificationManager 是一个重要的系统服务，应用程序可通过 NotificationManager 向系统发送全局通知。

-------------------------------------------------

	|--AlertDialog (对话框): 功能最丰富、实际应用最广的对话框。
		|--DatePickerDialog (日期选择对话框): 这个对话框只是对 DatePicker 的包装。
		|--TimePickerDialog (时间选择对话框): 这个对话框只是对 TimePicker 的包装。
		|--ProgressDialog (进度对话框): 这个对话框只是读进度条的包装。

-------------------------------------------------

	|--Toast (提示消息框): 特点: 1. Toast 提示信息不回获取焦点。 2. Toast 提示信息过一段时间会自动消失。

-------------------------------------------------

	|--ActionBar (活动条)
	
	
```
FragmentTest
---------
DB
---------



```Java
public class OkHttpUtil {

    private static OkHttpClient client;
    private static OkHttpClient fileClient;

}
```

```Java
public static void main()

```

<http://www.baidu.com>  
`<http://www.baidu.com>`

[baidu](http://www.baidu.com)

* TITLE
* Title
- w  
	* t 
	* y 
		1. we 
		2. omg




[arbitrary_id]: http://www.baidu.com "Title"

		
> a  
> b
> > c
> > > d  
> > > >q
> > 
> > w
>
> e  
> 
> * f  
> * [baidu][arbitrary_id]
> * g



`ready`

	ready
		12345
		
Table
-----
First|Second
---|---
content|content
content|content 

left|center|right
:---:|:----:|:---:
1|2|3
4|5|6



~~~
ee
~~e
e


e
e
```
~~~