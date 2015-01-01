package filepath;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/*Files.walkFileTree(Path start,FileVisitor<? super Path> visitor)的作用是遍历目录树
 * 它与上一个的区别是DirectoryStream只能遍历一个目录，而walkFileTree能递归的遍历一个目录下的所有目录
 * 但一看walkFileTree的二个参数就不是善茬，它得实现下面的4个方法
 * FileVisitResult 	postVisitDirectory(T dir, IOException exc)
 * FileVisitResult 	preVisitDirectory(T dir, BasicFileAttributes attrs)
 * FileVisitResult 	visitFile(T file, BasicFileAttributes attrs)
 * FileVisitResult 	visitFileFailed(T file, IOException exc)
 * 但好在java1.7已经提供了一个默认实现类SimpleFileVisitor，这样你就可以只用重写一遍你需要的方法了
 * 下面的例子是打印一个目录下所有文件的名称（文件夹的名称是不会被打印的）
 */

public class FileTree {
	public static void main(String[] args) throws IOException {
		Path dir3 = Paths.get("c:\\test");
		Files.walkFileTree(dir3, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file,
					BasicFileAttributes attrs) throws IOException {
				System.out.println(file.getFileName());
				return FileVisitResult.CONTINUE;
			}
		});
	}
}
