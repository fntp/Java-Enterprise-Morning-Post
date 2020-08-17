package com.sinsy.fntp.news;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import com.sinsy.fntp.baiduRank.GetTheListOfBaiDu;
import com.sinsy.fntp.date.GetCurrentDate;
import com.sinsy.fntp.sayhello.sayHello;
import com.sinsy.fntp.where.Location;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class newsmanwindows {

	protected Shell shell;
	private Text shuchu;
	private Text weiba;
	private boolean flag=false;
	private boolean currentdate_open= false;
	private boolean hello = false;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			newsmanwindows window = new newsmanwindows();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(482, 577);
		shell.setText("\u946B\u8F6F\u6668\u62A5\u751F\u6210");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(10, 10, 444, 110);
		
		Label lblNewLabel = new Label(composite, SWT.BORDER);
		lblNewLabel.setImage(SWTResourceManager.getImage(newsmanwindows.class, "/img/2.png"));
		lblNewLabel.setBounds(0, 0, 444, 110);
		Composite composite_1 = new Composite(shell, SWT.BORDER);
		composite_1.setBounds(10, 126, 444, 64);
		Combo combo = new Combo(composite_1, SWT.NONE);
		combo.setItems(new String[] {"\u70ED\u641C\u699C", "\u5173\u6CE8\u5EA6", "\u8BC4\u8BBA\u91CF"});
		combo.setBounds(338, 22, 92, 28);
		combo.setText("\u4F18\u5148\u9009\u62E9");
		Combo newssources = new Combo(composite_1, SWT.NONE);
		newssources.setItems(new String[] {"\u767E\u5EA6\u70ED\u699C", "\u65B0\u6D6A\u70ED\u699C", "\u7F51\u6613\u70ED\u699C"});
		newssources.setBounds(240, 22, 92, 28);
		newssources.setText("\u9009\u62E9\u6765\u6E90");
		
		weiba = new Text(composite_1, SWT.BORDER);
		weiba.setBounds(107, 22, 127, 26);
		
		Label label = new Label(composite_1, SWT.NONE);
		label.setBounds(10, 25, 91, 20);
		label.setText("\u8BF7\u60A8\u8F93\u5165\u5C3E\u5DF4");
		Composite composite_1_1 = new Composite(shell, SWT.BORDER);
		composite_1_1.setBounds(10, 196, 444, 78);
		Button weather = new Button(composite_1_1, SWT.CHECK);
		weather.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(weather.getSelection()) 
					flag=!flag;
			}
		});
		weather.setBounds(10, 30, 84, 20);
		weather.setText("\u663E\u793A\u5929\u6C14");
		
		Button currentdate = new Button(composite_1_1, SWT.CHECK);
		currentdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(currentdate.getSelection())
					currentdate_open = !currentdate_open;
			}
		});
		currentdate.setBounds(109, 30, 121, 20);
		currentdate.setText("\u663E\u793A\u65F6\u95F4\u65E5\u671F");
		
		Button sayhello = new Button(composite_1_1, SWT.CHECK);
		sayhello.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(sayhello.getSelection())
						hello = !hello;
			}
		});
		sayhello.setBounds(238, 30, 99, 20);
		sayhello.setText("\u663E\u793A\u95EE\u5019\u8BED");
		
		Button btnNewButton = new Button(composite_1_1, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				断报报文
				String news=new GetTheListOfBaiDu().getNewsBynow();
//				小尾巴
				String wb=weiba.getText();
//				位置与天气
				String locationandweather = new Location().SplitTheJson();
//				当前日期
				String date = new GetCurrentDate().GetDate();
//				励志语句
				String sayhello = new sayHello().SplitTheJson2(new sayHello().randomnumber());
				if(flag&&currentdate_open&&hello)
					shuchu.setText(wb+"\n"+date+"\n"+locationandweather+"\n"+news+"【今日微语录】："+sayhello);
			}
		});
		btnNewButton.setBounds(352, 25, 78, 30);
		btnNewButton.setText("\u4E00\u952E\u751F\u6210");
		
		Composite composite_1_2 = new Composite(shell, SWT.NONE);
		composite_1_2.setBounds(10, 280, 444, 240);
		
		shuchu = new Text(composite_1_2, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		shuchu.setBounds(0, 0, 444, 240);

	}
}
