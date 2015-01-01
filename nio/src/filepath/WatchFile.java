package filepath;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchFile {
	public static void main(String[] args) throws IOException,
			InterruptedException {
		try (WatchService watcher = FileSystems.getDefault().newWatchService()) {
			Path dir = Paths.get("c:\\test");
			WatchKey key = dir.register(watcher,
					StandardWatchEventKinds.ENTRY_DELETE);
			for (;;) {
				key = watcher.take();
				for (WatchEvent<?> event : key.pollEvents()) {
					System.out.println(event.kind());
				}
				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}
		}
	}
}
