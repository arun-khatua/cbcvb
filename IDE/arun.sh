jpackage \
  --type exe \
  --input target \
  --name IDES \
  --main-jar IDES.jar \
  --main-class com.example.ide.ide.MainApp \
  --icon icon.ico \
  --java-options "--module-path /home/arun/Desktop/javafx-17.15/lib --add-modules javafx.controls,javafx.fxml"
