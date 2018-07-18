/*
 * MultiThread.java created on 2017��5��16�� ����2:42:53 by lenovo
 */

package pachong;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * TODO javadoc for pachong.MultiThread
 * @Copyright: 2017�����׽��Ƽ��ɷ����޹�˾
 * @author: lenovo
 * @since: 2017��5��16��
 */
class mythread implements Runnable {

	long count;

	public void run() {
		try {
			for (; this.count < 1813454114; this.count++) {
				//				PrintWriter printWriter = new PrintWriter(new FileWriter(new File("D:/eking_project/maven/pachong/src/pachong/baidu/Data/url.txt"), true));
				//				PrintWriter cachePrintWriter = new PrintWriter(new FileWriter(new File("D:/eking_project/maven/pachong/src/pachong/baidu/Cache/index.txt"), false));
				//				cachePrintWriter.println(this.count);
				//				cachePrintWriter.close();
				String url = "http://pan.baidu.com/wap/share/home?uk=" + this.count;
				Document doc = Jsoup.connect(url).timeout(1000000).get();
				String title = doc.title();
				System.out.println("���0" + title + this.count);
				Element content = doc.body();
				Elements emptytag = content.select(".empty-other"); //���Ƿ��з��� Ϊ�������з���               
				if (emptytag.isEmpty()) {
					System.out.println("�з���");
					Elements dataems = content.select("[data-ac=active]");
					for (Element dataem : dataems) {
						Elements lists = dataem.select(".list-item");
						String sourcename = dataem.attr("data-fn");
						if (sourcename != "") {
							if (!sourcename.matches("^\\w+.[^sS]+$|^\\w+[-]\\w+.[^sS]+$|^\\w+[.?!;]\\w+.[^Ss]+$|\\w+|^.*[!��?��].*$")) {
								System.out.println("��������");
								if (sourcename.indexOf("ҽԺ") == -1 && sourcename.indexOf("�Ա�") == -1 && sourcename.indexOf("��Ʊ") == -1 && sourcename.indexOf("����") == -1
										&& sourcename.indexOf("��") == -1 && sourcename.indexOf("˫ɫ��") == -1 && sourcename.indexOf("��ҵ") == -1 && sourcename.indexOf("��ѯ") == -1
										&& sourcename.indexOf("׬") == -1 && sourcename.indexOf("����") == -1 && sourcename.indexOf("Ӫ��") == -1 && sourcename.indexOf("����") == -1
										&& sourcename.indexOf("cfˢǹ") == -1 && sourcename.indexOf("����") == -1 && sourcename.indexOf("�齫") == -1 && sourcename.indexOf("����") == -1
										&& sourcename.indexOf("��й") == -1 && sourcename.indexOf("����") == -1 && sourcename.indexOf("��Ƥ") == -1 && sourcename.indexOf("��") == -1
										&& sourcename.indexOf("��") == -1 && sourcename.indexOf("����") == -1 && sourcename.indexOf("��") == -1 && sourcename.indexOf("�ļ�") == -1
										&& sourcename.indexOf("�ĸ�") == -1 && sourcename.indexOf("����") == -1 && sourcename.indexOf("�п�") == -1 && sourcename.indexOf("����") == -1
										&& sourcename.indexOf("��") == -1 && sourcename.indexOf("���") == -1 && sourcename.indexOf("qq") == -1 && sourcename.indexOf("QQ") == -1
										&& sourcename.indexOf("����") == -1 && sourcename.indexOf("�߿�־Ը") == -1 && sourcename.indexOf("����") == -1 && sourcename.indexOf("�½�") == -1
										&& sourcename.indexOf("��") == -1 && sourcename.indexOf("��ѹ") == -1 && sourcename.indexOf("��") == -1 && sourcename.indexOf("��") == -1
										&& sourcename.indexOf("����") == -1 && sourcename.indexOf("�̺�") == -1 && sourcename.indexOf(".exe") == -1 && sourcename.indexOf("ˢ") == -1
										&& sourcename.indexOf(".com") == -1 && sourcename.indexOf("��Ů") == -1) {
									System.out.println("���1=" + sourcename);
									//									printWriter.println(sourcename);
									for (Element listem : lists) {
										String linkHref = url + listem.attr("href");
										//										printWriter.println(linkHref);
										System.out.println("����=" + linkHref);
									}
								} else {
									System.out.println("���2=" + sourcename);
								}
							} else {
								System.out.println("������");
							}
						}
					}
				}
				//				printWriter.close();
				//				cachePrintWriter.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}
	}
	
}

public class MultiThread {

	public static void main(String args[]) {

		mythread my = new mythread();
		/*try {
			FileReader text = new FileReader("D:/eking_project/maven/pachong/src/pachong/baidu/Cache/index.txt");
			BufferedReader buff = new BufferedReader(text);
			String index = buff.readLine();
			my.count = Long.parseLong(index);
		} catch (IOException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}*/
		for (int i = 0; i < 100; i++) {
			new Thread(my).start();
		}
	}
}
