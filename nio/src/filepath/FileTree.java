package filepath;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileTree {
	public static void main(String[] args) throws IOException {
		Path dir3 = Paths.get("c:\\test");
		Files.walkFileTree(dir3, new FileJavaVisitor());
	}
	private static class FileJavaVisitor extends SimpleFileVisitor<Path> {
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
			if(file.toString().endsWith(".java")) {
				System.out.println(file.getFileName());
			}
			return FileVisitResult.CONTINUE;
		}
	}
}
