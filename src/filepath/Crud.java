package filepath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Crud {
	public static void main(String[] args) throws IOException {
		Path dir4 = Paths.get("c:\\test\\del");
		Files.delete(dir4);// 删除文件或文件夹；删除文件夹时，若文件夹中还有文件或文件夹则抛出异常
		Files.deleteIfExists(dir4);// 如果存在该文件或文件夹则删除
		
		/*Files.copy(Path source,Path target,CopyOption... options)
		 *前两个参数分别为原路径和目的路径，第三个参数为复制选项
		 *StandardCopyOption.REPLACE_EXISTING：如果目的路径有同名文件则替换
		 *StandardCopyOption.ATOMIC_MOVE：若失败则回滚
		 *StandardCopyOption.COPY_ATTRIBUTES：把源文件的文件属性一同复制给新文件(readAttributes等方法可以读取文件属性)
		 **/
		Path source = Paths.get("c:\\test\\Hello.java");
		Path target = Paths.get("c:\\test\\Hello\\World\\Hello.java");
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		
		/*Files.move(Path source,Path target,CopyOption... options)
		 * 与复制同理，这里用move实现了给文件重命名的工作
		 * Path source = Paths.get("c:\\test\\Hello\\World\\Hello.java");
		Path target = Paths.get("c:\\test\\Hello\\World\\He.java");
		Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);*/
		
		
	}
}
