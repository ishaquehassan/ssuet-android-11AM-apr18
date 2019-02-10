const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp();
// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions
//

exports.helloWorldAgain = functions.https.onRequest((request, response) => {
    admin.database().ref("functionData").set("Hello world from function!");
    response.send("Hello from Firebase! SSUET");
});
exports.helloWorldGet = functions.https.onRequest((request, response) => {
    admin.database().ref("functionData").once("value", (snap) => {
        response.send(snap.val());
    });
});

exports.onFunValueChange = functions.database.ref("functionData").onUpdate((snapshot, context) => {
    let myVal = snapshot.after.val().toUpperCase()+" SSUET";
    admin.database().ref("hello").set(myVal);
    return snapshot.after.val()
});