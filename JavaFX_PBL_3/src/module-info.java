module JavaFX_PBL_3 {
	
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.desktop;
	
	opens applicationcontroller to javafx.fxml;
	opens applicationmain to javafx.graphics;
}
