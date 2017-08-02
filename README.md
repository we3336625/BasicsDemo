BasicsDemo
=======


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
		|			而 ImageButton 上则显示图片。
		|		|--ZoomButton (缩放按钮): ZoomButton 可以代表 “放大” 、“缩小” 两个按钮。
		|				ZoomButton 的行为基本类似于 ImageButton, 只是 Android 默认提供了 btn_minus 、
		|				btn_plus, 即可实现 “缩小” 、 “放大” 按钮。
		|
		|	|--QuickContactBadge (显示关联到特定联系人的图片): QuickContactBadge 继承了 ImageView ，
		|			因此它的本质也是图片按钮，也可以通过 src 属性指定它显示的图片。 
		|			QuickContactBadge 额外增加的功能是: 该图片可以关联到手机中指定联系人，
		|			当用户点击该图片时，系统将会打开相应联系人的联系方式界面。
		|
		|
		|--ProgressBar (进度条): 通常用于向用户显示某个耗时操作完成的百分比。
		|		进度条可以动态的显示进度，因此避免长时间的执行某个耗时操作时，
		|		让用户感觉程序失去了响应，提高用户界面的友好性。
		|	|--AbsSeekBar
		|		|--SeekBar (拖动条): 通过滑块的位置来标识数值，允许用户拖动滑块来改变值，
		|				因此拖动条通常用于对系统的某种数值进行调节，如调节音量。
		|		|--RatingBar (星级评分条): 用法、功能与拖动条 SeekBar 接近：都允许用户通过拖动来改变进度。
		|				区别在于： RatingBar 通过星星来表示进度。
		|
		|
		|--TextView (文本框)
		|	|--Button (按钮): Button继承了 TextView，它主要是在UI界面上生成一个按钮，该按钮可以供用户单击，
		|			当用户单击按钮时，按钮会触发一个 onClick 事件。
		|		|--CompoundButton
		|			|--CheckBox (复选框): 与 Button 不同的是，多了一个可选中的功能，可额外指定一个 cheched 属性，
		|					该属性可指定是否被选中。可选择多个。
		|			|--RadioButton (单选钮): 与 Button 不同的是，多了一个可选中的功能，可额外指定一个 cheched 属性，
		|					该属性可指定是否被选中。只能选择其中一个，通常要与 RadioGroup 一起使用，用于定义一组单选按钮。
		|			|--Switch (开关): 通常用于切换程序中的某种状态。
		|			|--ToggleButton (状态开关按钮): 通常用于切换程序中的某种状态。
		|
		|	|--EditText (编辑框)
		|		|--AutoCompleteTextView (自动完成的文本框): 从 EditText 派生而出，实际上它也是一个文本编辑框，
		|					但它比普通编辑框多了一个功能: 当用户输入一定字符之后，自动完成文本框会显示一个下拉菜单，
		|					供用户从中选择，当用户选择某个菜单项之后， AutoCompleteTextView 按用户选择自动填写该文本框。
		|					(使用时，只要设置一个 Adapter即可，该 Adapter封装了 AutoCompleteTextView预设的提示文本)
		|			|--MultiAutoCompleteTextView: 功能与 AutoCompleteTextView 基本相似，
		|						只是 MultiAutoCompleteTextView 允许输入多个提示项，多个提示项以分隔符分割。
		|						MultiAutoCompleteTextView 提供了 setTokenizer() 方法来设置分隔符。
		|		|--ExtractEditText: 它不是 UI组件，而是 EditText 组件的底层服务类，负责提供全屏输入法支持。
		|
		|	|--TextClock (时钟): TextClock 本身就继承了 TextView,也就是说，他本身就是文本框，
		|			只是它里面显示的内容总是当前时间。与 TextView 不同的是，为 TextClock 设置 text 属性没什么作用。
		|	|--Chronometer (计时器): 该组件与 TextClock 都继承 TextView，因此它们都会显示一段文本。
		|			但 Chronometer 并不显示当前时间，它显示的是从某个起始时间开始，一共过去了多长时间。
		|	|--CheckedTextView
		|
		|
		|--AnalogClock (时钟)	//Deprecated
		|--ViewGroup
			|--AdapterView: 1.AdapterView 继承了 ViewGroup ，他的本质是容器。
			|			2. AdapterView 可以包括多个 “列表项”，并将多个 “列表项” 以合适的形式显示出来。
			|			3. AdapterView 显示的多个 “列表项” 由 Adapter 提供。
			|			调用 AdapterView 的 setAdapter(Adapter) 方法设置 Adapter 即可。
			|	|--AbsListView
			|		|--GridView (网格视图): 用于在界面上按 行、列 分布的方式来显示多个组件。			|					(如果让 GridView 只显示一列，那个该 GridView 就变成了 ListView)
			|		|--ListView (列表视图): ListView是手机系统中使用非常广泛的一种组件，它以垂直列表的形式显示所有列表项。
			|			|--ExpandableListView (可展开的列表组件): 是 ListView 的子类，
			|					它在普通 ListView 的基础上进行了扩展，它把应用中的列表项分为几组，
			|					每组里又可包含多个列表项。  用法与普通 ListView 的用法非常相似，
			|					只是 ExpandableListView 所显示的列表项应该由 ExpandableListAdapter 提供。
			|
			|	|--AbsSpinner
			|		|--Gallery: 显示的是一个水平列表选择框。 允许用户通过拖动来查看上一个、下一个列表项。	//Deprecated
			|		|--Spinner (列表选择框): 显示的是一个垂直列表选择框。作用是供用户选择。 
			|			(entries 使用数组资源设置该下拉列表框的列表项。 或使用 Adapter 为 Spinner 提供列表项。)
			|
			|	|--AdapterViewAnimator
			|		|--AdapterViewFlipper(): 它会显示 Adapter 提供的多个 View 组件，但它每次只能显示一个 View 组件，
			|				通过 showPrevious() 和 showNext() 方法控制该组件显示 上一个、下一个 组件。
			|		|--StackView: 用于显示 Adapter 提供的一系列 View。"堆叠(Stack)" 的方式显示多个列表项。 
			|				提供了如下两种控制方式: 
			|				1. 拖走 StackView 中处于顶端的 View， 下一个 View 将会显示出来。
			|				将上一个 View 拖进 StackView， 将使之显示出来。 
			|				2. 通过调用 StackView 的 showNext() 、showPrevious() 控制显示下一个、上一个组件。
			|
			|--AbsoluteLayout (绝对布局): 通过X坐标、Y坐标来控制组件的位置。	//Deprecated
			|--GridLayout (网格布局): 它把整个容器划分为 rows × columns 个网格，每个网格可以放置一个组件。
			|			除此之外，也可以设置一个组件横跨多少列、一个组件纵跨多少行 (Android 4.0新增的布局管理器)
			|--RelativeLayout (相对布局): 相对布局容器内子组件的位置总是相对兄弟组件、父容器来决定的，
			|			因此这种布局方式被称为相对布局
			|--FrameLayout (帧布局): 帧布局容器为每个假如其中的组件创建一个空白的区域(称为一帧)，每个子组件占据一帧，
			|			这些帧都会根据gravity属性执行自动对齐。
			|	|--CalendarView (日历视图)
			|	|--DatePicker (日期选择器)
			|	|--TimePicker (时间选择器)
			|	|--ScrollView (滚动视图): 一个用于为普通组件添加滚动条的组件。 ScrollView里面最多只能包含一个组件，
			|				ScrollView 作用就是为该组件添加垂直滚动条。
			|	|--HorizontalScrollView: 添加水平滚动条。
			|	|--TabHost (选项卡)
			|	|--ViewAnimator (可以在View切换时表现出动画效果)
			|		|--ViewFlipper: addView(View view) 添加多个组件，一旦向ViewFlipper 中添加了多个组件之后，
			|					ViewFlipper 就可使用动画控制多个组件之间的切换效果
			|		|--ViewSwitcher (视图切换组件): 它本身继承了 FrameLayout， 因此可以将多个 View 层叠在一起，
			|					每次只显示一个组件。当程序控制从一个 View 切换到另一个 View 时， 
			|					ViewSwitcher 支持指定动画效果。   为了给 ViewSwitcher 添加多个组件，
			|					一般通过调用 ViewSwitcher 的 setFactory(ViewSwitcher.ViewFactory) 
			|					方法为之设置 ViewFactory， 并由该 ViewFactory 为之创建 View 即可。
			|			|--ImageSwitcher (图像切换器): 具有与 ViewSwitcher 相同的特征: 
			|						可以再切换 View 组件时使用动画效果。 使用步骤: 1. 为 ImageSwitcher 提供一个 
			|						ViewFactory， 该 ViewFactory 生成的 View 组件必须是 ImageView。 
			|						2. 需要切换图片时，只要调用 ImageSwitcher 的 
			|						setImageDrawable(Drawable drawable)、 setImageResource(int resid) 和 
			|						setImageURI(Uri uri) 方法更新图片即可。
			|			|--TextSwitcher (文本切换器): 具有与 ViewSwitcher 相同的特征: 
			|						可以再切换 View 组件时使用动画效果。与 ImageSwitcher 相似的是：
			|						也需要设置一个 ViewFactory。 不同的是：TextSwitcher 所需的 ViewFactory 
			|						的 mackView() 方法必须返回一个 TextView 组件。
			|
			|--LinearLayout (线性布局): 可以控制各组件横向排列，可以控制各组件纵向排列(通过设置 orientation 属性控制)。
			|	|--TableLayout (表格布局): 采用行、列的形式来管理 UI组件，通过添加 TableRow、
			|				其他组件来控制表格的行数、列数。
			|	|--NumberPicker (数值选择器)
			|	|--SearchView (搜索框): 可以让用户在文本框内输入文字，并允许通过监听器监控用户输入，
			|				当用户输入完成后提交搜索时，也可通过监听器执行实际的搜索。
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
			|				该方法的返回值决定第position处的列表项组件。
			|
			|
				|--SimpleAdapter: 并不简单、功能强大的 adapter，可用于将 List 集合的多个对象包装成多个列表项。
				|			new SimpleAdapter(Context context, 
				|				List<? extends Map<String, ?>> data, 
				|				@LayoutRes int resource, 
				|				String[] from, 
				|				@IdRes int[] to) 
				|
				|
				|--ArrayAdapter<T>: 简单、易用的adapter，通常用于将数组或 List 集合的多个值包装成多个列表项。
				|			new ArrayAdapter(@NonNull Context context, 
				|				@LayoutRes int resource, 
				|				@IdRes int textViewResourceId, 
				|				@NonNull T[] objects)
				|			new ArrayAdapter(@NonNull Context context, 
				|				@LayoutRes int resource, 
				|				@IdRes int textViewResourceId, 
				|				@NonNull List<T> objects)
				|
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
	|--NotificationManager 是一个重要的系统服务，应用程序可通过 NotificationManager 向系统发送全局通知。

-------------------------------------------------

	|--AlertDialog (对话框): 功能最丰富、实际应用最广的对话框。
		|--DatePickerDialog (日期选择对话框): 这个对话框只是对 DatePicker 的包装。
		|--TimePickerDialog (时间选择对话框): 这个对话框只是对 TimePicker 的包装。
		|--ProgressDialog (进度对话框): 这个对话框只是读进度条的包装。

-------------------------------------------------

	|--Toast (提示消息框): 特点: 1. Toast 提示信息不回获取焦点。 2. Toast 提示信息过一段时间会自动消失。

-------------------------------------------------

	|--ActionBar (活动条)
	
-------------------------------------------------

	Handler
		主要作用: 
			1. 在新启动的线程中发送消息。
			2. 在主线程中获取、处理消息。
		
		新启动的线程何时发送消息？主线程何时去获取并处理消息？
			重写 Handler 类中处理消息的方法，当新启动的线程发送消息时，消息会发送到与之关联的 MessageQueue，
			而 Handler 会不断的从 MessageQueue 中获取并处理消息————这将导致 Handler 中处理消息的方法被回调。
			
		Handler 包含如下方法用于发送、处理消息：
			void handleMessage(Message msg): 处理消息的方式。该方法通常用于被重写。
			final boolean hasMessages(int what): 检查消息队列中是否包含 what 属性为指定值的消息。
			final boolean hasMessages(int what, Object object): 检查消息队列中是否包含 what 属性为指定值且 
					object 属性为指定对象的消息。
			多个重载的 final Message obtainMessage(): 获取消息。
			final boolean sendEmptyMessage(int what): 发送空消息。
			final boolean sendEmptyMessageDelayed(int what, long delayMillis): 指定多少毫秒之后发送空消息。
			final boolean sendMessage(Message msg): 立即发送消息。
			final boolean sendMessageDelayed(Message msg, long delayMillis): 指定多少毫秒之后发送消息。
			
		Handler、Loop、MessageQueue 的工作原理：
			Message: Handler 接收和处理的消息对象。
			Looper: 每个线程只能拥有一个Looper。它的 loop 方法负责读取 MessageQueue 中的消息，
					读到信息之后就把消息交给发送该消息的 Handler 进行处理。
			MessageQueue: 消息队列，它采用先进先出的方式来管理 Message。程序创建 Looper 对象时，
					会在它的构造器中创建 MessageQueue 对象。由 Looper 负责管理。
			Handler: 它能把消息发送给 Looper 管理的 MessageQueue，并负责处理 Looper 分给它的消息。
				> 在主UI线程中，系统已经初始化了一个 Looper 对象，因此程序直接创建 Handler 即可，
						然后就可通过 Handler 来发送消息、处理消息了。
				> 在子线程中，必须自己创建一个 Looper 对象，并启动它。
						创建 Looper 对象调用它的 prepare() 方法即可。
			
		在线程中使用 Handler 的步骤:
			1. 调用 Looper 的 prepare() 方法为当前线程创建 Looper 对象，创建 Looper 对象时，
					它的构造器会创建与之配套的 MessageQueue。
			2. 有了 Looper 之后，创建 Handler 子类的实例，重写 handlerMessage() 方法，
					该方法负责处理来自于其他线程的消息。
			3. 调用 Looper 的 loop() 方法启动 Looper。
			
-------------------------------------------------

	AsyncTask
		为了解决新线程不能更新UI组件的问题，Andoird 提供了如下几种解决方案：
			1. 使用 Handler 实现线程之间的通信。
			2. Activity.runOnUiThread(Runnable)
			3. View.post(Runnable)
			4. View.postDelayed(Runnable, long)
		
		AsyncTask 更轻量级一些，适用于简单的异步处理，不需要借助线程和 Handler 即可实现。
		AsyncTask<Params, Progress, Result> 是一个抽象类，通常用于被继承，继承 AsyncTask 时需要制定如下三个泛型：
			> Params: 启动任务执行的 输入参数 的类型。
			> Progress: 后台任务完成的 进度值 的类型。
			> Result: 后台执行任务完成后 返回结果 的类型。
		
		使用 AsyncTask 只要如下三步：
			1. 创建 AsyncTask 的子类，并为三个泛型参数指定类型。如果某个泛型参数不需要指定类型，则可将它指定为Void。
			2. 根据需要，实现 AsyncTask 如下方法：
				> Result doInBackground(Params... params): 重写该方法就是后台线程将要完成的任务。
						该方法可以调用 publishProgress(Progress... values) 方法更新任务的执行进度。
				> void onProgressUpdate(Progress... values): 在 doInBackground() 方法中调用 publishProgress() 
						方法更新任务的执行进度后，将会触发该方法。
				> void onPreExecute(): 该方法将在执行后台耗时操作前被调用。通常该方法用于完成一些初始化的准备工作。
				> void onPostExecute(Result result): 当 doInBackground() 完成后，系统会自动调用 onPostExecute() 
						方法，并将 doInBackground() 方法的返回值传给该方法。
	
	
	
	
```


ActivityTest
----------

```Java
	|--Context
		|--ContextWrapper
			|--ContextThemeWrapper
				|--Activity
					|--AccountAuthenticatorActivity: 实现账户管理界面的 Activity
					|--ActivityGroup	//Deprecated
						|--TabActivity: 实现Tab界面的 Activity	//Deprecated
					|--AliasActivity: 别名Activity的基类，启动其它 Activity 时结束自己
					|--ExpandableListActivity: 实现可展开列表界面的Activity
					|--FragmentActivity
					|--ListActivity: 实现列表界面的 Activity
						|--LaucherActivity: 实现Activity列表界面的 Activity，当单击列表项时，所对应的Activity被启动
						|--PreferenceActivity: 实现程序参数设置，存储界面的 Activity
						
						
		Activity 生命周期:
			> onCreate(@Nullable Bundle savedInstanceState): 创建 Activity 时被回调。该方法只会被调用一次。
			> onStart(): 启动 Activity 时被回调。
			> onRestart(): 重新启动 Activity 时被回调。
			> onResume(): 恢复 Activity 时被回调。在 onStart() 方法后一定会回调 onResume() 方法。
			> onPause(): 暂停 Activity 时被回调。
			> onStop(): 停止 Activity 时被回调。
			> onDestroy(): 销毁 Activity 时被回调。该方法只会被调用一次。
			
		Activity 加载模式：
			> standard: 标准模式，这是默认的加载模式。
				每次通过这种模式来启动目标 Activity 时，Android 总会为目标 Activity 创建一个新的实例，并将该 Activity 
			添加到当前 Task 栈中————这种模式不会启动新的 Task，新 Activity 将被添加到原有的 Task 中。
			
			> singleTop: Task 栈顶单列模式。
				这种模式与 standard 模式基本相似，但有一点不同: 当将要启动的目标 Activity 已经位于 Task 栈顶时，系统不会
			创建目标 Activity 的实例，而是直接复用已有的 Activity 实例。
				如果将要启动的目标 Activity 没有位于 Task 栈顶，此时系统会重新创建目标 Activity 的实例，并将它加载到 
			Task 栈顶————此时与 standard 模式完全相同。
			
			> singleTask: Task 内单列模式。
				采用这种加载模式的 Activity 在同一个 Task 内只有一个实例，当系统采用 singleTask 启动目标 Activity 时，
			可分为下面三种情况：
					1> 如果将要启动的目标 Activity 不存在，系统将会创建目标 Activity 的实例，并将它加入 Task 栈顶。
					2> 如果将要启动的目标 Activity 已经位于 Task 栈顶，此时与 singleTop 模式的行为相同。
					3> 如果将要启动的目标 Activity 存在但没有位于 Task 栈顶，系统将会把所有位于该 Activity 上面的所有 
				Activity 移除 Task 栈，从而使得目标 Activity 转入栈顶。
					
			> singleInstance: 全局单列模式。
				在这种加载模式下，系统保证无论从哪个 Task 中启动目标 Activity，只会创建一个目标 Activity 实例，并会使用
			一个全新的 Task 栈来加载该 Activity 实例。
				当系统采用 singleInstance 模式启动目标 Activity 时，可分为如下两种情况：
					1> 如果将要启动的目标 Activity 不存在，系统会先创建一个全新的 Task，在创建目标 Activity 的实例，
				并将它加入新的 Task 栈顶。
					2> 如果将要启动的目标 Activity 已经存在，无论它位于哪个应用程序中、位于哪个 Task 中，系统都会把
				Activity 所在的 Task 转到前台，从而使该 Activity 显示出来。
				
				采用 singleInstance 模式加载 Activity 总是位于 Task 栈顶，且采用 singleInstance 模式加载的 
			Activity 所在 Task 将只包含该 Activity。
			
			
			
						
```



FragmentTest
---------
```
	|--Fragment
		|--DialogFragment: 对话框界面的 Fragment
		|--ListFragment: 实现列表界面的 Fragment
		|--PreferenceFragment: 选项设置界面的 Fragment
		|--WebViewFragment: WebView 界面的 Fragment

	与 Activity 类似的是，Fragment 也存在如下状态：
		> 运行状态: 当前 Fragment 位于前台，用户可见，可以获得焦点。
		> 暂停状态: 其他 Activity 为与前台，该 Fragment 依然可见，只是不能获得焦点。
		> 停止状态: 该 Fragment 不可见，失去焦点。
		> 销毁状态: 该 Fragment 被完全删除，或该 Fragment 所在的 Activity 被结束。
	
	生命周期:
		> void onAttach(Activity activity): 当该 Fragment 被添加到 Activity 时被回调。 该方法只会被调用一次。
		> void onCreate(@Nullable Bundle savedInstanceState): 创建 Fragment 时被回调。 该方法只会被调用一次。
		> View onCreateView(LayoutInflater inflater, 
						@Nullable ViewGroup container, 
						Bundle savedInstanceState): 每次创建、绘制该 Fragment 的 View 组件时回调该方法，
											Fragment 将会显示该方法返回的 View 组件。
		> void onActivityCreated(@Nullable Bundle savedInstanceState): 当 Fragment 所在的 Activity 被启动完成
											后回调该方法。
		> void onStart(): 启动 Fragment 时被回调。
		> void onResume(): 恢复 Fragment 时被回调，在 onStart() 方法后一定会回调 onResume() 方法。
		> void onPause(): 暂定 Fragment 时被回调。
		> void onStop(): 停止 Fragment 时被回调。
		> void onDestroyView(): 销毁该 Fragment 所包含的 View 组件时调用。
		> void onDestroy(): 销毁 Fragment 时被回调。 该方法只会被调用一次。
		> void onDetach(): 将该 Fragment 从 Activity 中删除、替换完成时回调该方法，在 onDestroy() 方法后一定会
											回调 onDetach() 方法。 该方法只会被调用一次。


	
```
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