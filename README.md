# TensorFlow Lite Model Personalization Demo

### Overview

This is a camera app that continuously classifies the objects in the frames seen
by your device's back camera. This example illustrates a way of personalizing a
TFLite model on-device without sending any data to the server. It can be adapted
for various tasks and models. These instructions walk you through building and
running the demo on an Android device.

The model files are downloaded via Gradle scripts when you build and run the
app. You don't need to do any steps to download TFLite models into the project
explicitly.

This application should be run on a physical Android device.

![App example showing UI controls. Training mode.](screenshot1.jpg?raw=true
"Training mode")

![App example without UI controls. Inference mode.](screenshot2.jpg?raw=true
"Inference mode")

