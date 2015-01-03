package filepath;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class RwLine {
	public static void main(String[] args) throws IOException {
		Path source = Paths.get("c:\\test\\Hello\\World\\Ab.java");
		Path target = Paths.get("c:\\test\\Hello\\World\\He.java");
		/*
		 * java1.7中最棒的改进之一，就是吸取了优秀的第三方库经验(java8中的time包也是吸取joda的经验)
		 * 下面就是我最早在guava中看见，后来在java7中引入的 按行读和按行写
		 * 我自认为，这两个方法极大的提升了工作效率，而且性能优、安全性好
		 */
		
		//最好设置一下文件的编码格式，在StandardCharsets中有很多种内置编码格式
		List<String> list = Files.readAllLines(source, StandardCharsets.UTF_8);
		for (String s : list) {
			System.out.println(s);
		}
		//在StandardOpenOption中有很多种内置文件打开方式可供选择
		Files.write(target, list, StandardCharsets.UTF_8,
				StandardOpenOption.WRITE);
	}
}
