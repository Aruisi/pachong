/*
 * AntSpider.java created on 2017年5月16日 上午10:46:36 by lenovo
 */

package pachong;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Random;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * TODO javadoc for pachong.AntSpider
 * @Copyright: 2017海南易建科技股份有限公司
 * @author: lenovo
 * @since: 2017年5月16日
 */
public class AntSpider {

	private final static String baseUrl = "http://www.btcherry.info/search?keyword=";

	private static Scanner scanner;

	public static void main(String[] args) throws IOException {
		System.out.println("请输入需要搜索的关键词：");
		scanner = new Scanner(System.in);
		String inString = scanner.next();
		String key = URLEncoder.encode(inString, "utf-8");
		System.out.println("正在为您在网上搜寻数据呦，请稍后。。。");
		for (int i = 1; i < 11; i++) {
			Document doc = Jsoup.connect(baseUrl + key + "&p=" + i).header("User-Agent",
					"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").timeout(1000000).get();
			Element content = doc.getElementById("content");
			Document contentDoc = Jsoup.parse(content.toString());

			Elements r = contentDoc.getElementsByClass("r"); //选择器的形式
			String href = null;
			String href_end = null;
			for (Element el : r) {
				try {
					Document clearfixliDoc = Jsoup.parse(el.toString());
					Element link = clearfixliDoc.select("div a").last();
					href = link.attr("href");
					href_end = link.attr("href").substring(0, href.indexOf("&"));
					System.out.println(href_end);
				} catch (Exception ex) {

				}
			}
		}

	}
}
