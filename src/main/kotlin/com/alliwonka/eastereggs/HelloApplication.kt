package com.alliwonka.eastereggs

/*
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(
                HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}
*/

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import javafx.stage.Stage

class VoiceToTextChatApp : Application() {

    private val chatArea = TextArea()
    private val inputField = TextField()
    private val sendButton = Button("Send")

    override fun start(primaryStage: Stage) {
        primaryStage.title = "Voice to Text Chat Application"

        // Set up the UI components
        chatArea.isEditable = false
        sendButton.setOnAction { sendMessage() }

        val vbox = VBox(10.0)
        vbox.children.addAll(chatArea, inputField, sendButton)

        val scene = Scene(vbox, 400.0, 300.0)
        primaryStage.scene = scene

        primaryStage.show()
    }

    private fun sendMessage() {
        val message = inputField.text
        if (message.isNotEmpty()) {
            // Process and send the user's message to ChatGPT
            // Append the response to the chatArea
            chatArea.appendText("You: $message\n")
            inputField.clear()
        }
    }

    fun appendResponse(response: String) {
        // Append ChatGPT's response to the chatArea
        chatArea.appendText("ChatGPT: $response\n")
    }

    // You can implement voice input and other logic here

    // The main function is used for running the JavaFX application
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(VoiceToTextChatApp::class.java)
        }
    }
}
