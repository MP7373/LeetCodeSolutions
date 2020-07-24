class FileSystem {
  private File root;

  public FileSystem() {
      root = new File("/", true);
  }

  public List<String> ls(String path) {
      String[] parts = path.split("/");

      File relativePath = root;
      for (int i = 1; i < parts.length; i++) {
          if (relativePath.isDirectory() && relativePath.getChildren().containsKey(parts[i])) {
              relativePath = relativePath.getChildren().get(parts[i]);
          } else {
              return null;
          }
      }

      if (relativePath.isDirectory()) {
          List<String> files = new ArrayList<>();

          for (String key : relativePath.getChildren().keySet()) {
              files.add(relativePath.getChildren().get(key).getFilename());
          }

          return files;
      }

      return Arrays.asList(relativePath.getFilename());
  }

  public void mkdir(String path) {
      String[] parts = path.split("/");

      File relativePath = root;
      for (int i = 1; i < parts.length; i++) {
          if (relativePath.isDirectory() && relativePath.getChildren().containsKey(parts[i])) {
              relativePath = relativePath.getChildren().get(parts[i]);
          } else {
              relativePath.getChildren().put(parts[i], new File(parts[i], true));
              relativePath = relativePath.getChildren().get(parts[i]);
          }
      }
  }

  public void addContentToFile(String filePath, String content) {
      String[] parts = filePath.split("/");

      File relativePath = root;
      for (int i = 1; i < parts.length; i++) {
          if (relativePath.isDirectory() && relativePath.getChildren().containsKey(parts[i])) {
              relativePath = relativePath.getChildren().get(parts[i]);
          } else {
              relativePath.getChildren().put(parts[i], new File(parts[i], i < parts.length - 1 ? true : false));
              relativePath = relativePath.getChildren().get(parts[i]);
          }
      }

      relativePath.append(content);
  }

  public String readContentFromFile(String filePath) {
      String[] parts = filePath.split("/");

      File relativePath = root;
      for (int i = 1; i < parts.length; i++) {
          if (relativePath.isDirectory() && relativePath.getChildren().containsKey(parts[i])) {
              relativePath = relativePath.getChildren().get(parts[i]);
          } else {
              return null;
          }
      }

      return relativePath.read();
  }
}

class File {
  private String filename;
  private StringBuilder fileContent = new StringBuilder();
  private TreeMap<String, File> children = null;

  File(String filename, boolean isDirectory) {
      this.filename = filename;

      if (isDirectory) {
          children = new TreeMap<>();
      }
  }

  public boolean isDirectory() {
      return children != null;
  }

  public String getFilename() {
      return filename;
  }

  public String read() {
      return fileContent.toString();
  }

  public void append(String content) {
      fileContent.append(content);
  }

  public Map<String, File> getChildren() {
      return children;
  }
}

/**
* Your FileSystem object will be instantiated and called as such:
* FileSystem obj = new FileSystem();
* List<String> param_1 = obj.ls(path);
* obj.mkdir(path);
* obj.addContentToFile(filePath,content);
* String param_4 = obj.readContentFromFile(filePath);
*/