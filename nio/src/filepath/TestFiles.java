package filepath;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFiles {
	public static void main(String[] args) throws IOException {
		Path dir0 = Paths.get("c:\\test");// 创建一个Path路径；Paths是工具类
		Files.createDirectory(dir0);// 创建单级目录；若已经存在 则抛出异常
		Path dir1 = Paths.get("c:\\test\\Hello.java");
		Files.createFile(dir1);// 创建文件；若目录没有 则抛出异常
		Path dir2 = Paths.get("c:\\test\\Hello\\World");
		Files.createDirectories(dir2);// 创建多级目录；若已经存在 不抛出异常

		Path dir3 = Paths.get("c:\\test");
		// 1.DirectoryStream可以理解成对于Path的Iterable，返回在dir3中符合第二个参数形式的Path集合
		// 2.下面用到了一种try-with-resources的写法，该写法是在java1.7中引入的语法糖（极力推荐大家用该写法，因为它可以帮助你正确的关闭资源）
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir3,
				"*.java")) {
			for (Path entry : stream) {
				System.out.println(entry.getFileName());
			}
		}
	}
}
