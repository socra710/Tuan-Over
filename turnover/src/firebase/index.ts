import { initializeApp } from "firebase/app";

const firebaseConfig = { 
    apiKey: "AIzaSyAJka5nODioFuXZhkCvRmkih6At-1Crkhk",
    authDomain: "tuan-over.firebaseapp.com",
    projectId: "tuan-over",
    storageBucket: "tuan-over.appspot.com",
    messagingSenderId: "480325200312",
    appId: "1:480325200312:web:35ce98eb0ed9c2ff47074d",
    measurementId: "G-TXGWVNG2R6"
};

const firebase = initializeApp(firebaseConfig);

export default firebase;