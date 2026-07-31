# 📩 SMS Forwarder for Android

A lightweight Android application that automatically receives incoming SMS messages and forwards them to a Telegram chat using the Telegram Bot API.

> Built with Java for Android.

---

##  Features

- Receive incoming SMS messages in real-time.
- Forward every SMS directly to Telegram.
- Lightweight and fast.
- Simple permission management.
- Works in the background using BroadcastReceiver.

---

## How It Works

1. The application requests SMS permissions.
2. Android delivers incoming SMS to the `BroadcastReceiver`.
3. The sender number and message content are extracted.
4. The application sends the message to your Telegram Bot.
5. The message instantly appears inside your Telegram chat.

```
Incoming SMS
      │
      ▼
 BroadcastReceiver
      │
      ▼
 Extract Sender + Message
      │
      ▼
 Telegram Bot API
      │
      ▼
 Telegram Chat
```

---

## Project Structure

```
app/
├── MainActivity.java      # Requests SMS permissions
├── SmsReceiver.java       # Receives SMS and forwards to Telegram
└── AndroidManifest.xml
```

---

## Requirements

- Android Studio
- Java
- Android SDK
- Telegram Bot
- Telegram Chat ID

---

## Configuration

Inside `SmsReceiver.java`, replace:

```java
private static final String BOT_TOKEN = "YOUR_BOT_TOKEN";
private static final String CHAT_ID = "YOUR_CHAT_ID";
```

with your own Telegram Bot credentials.

---

## Telegram Bot Setup

### 1. Create a Bot

Open Telegram and chat with:

```
@BotFather
```

Create a new bot:

```
/newbot
```

Copy the generated Bot Token.

---

### 2. Get your Chat ID

Send a message to your bot.

Then open:

```
https://api.telegram.org/bot<YOUR_TOKEN>/getUpdates
```

Locate:

```json
"chat": {
    "id": 123456789
}
```

Use this value as your Chat ID.

---

## Required Permissions

The application requires:

- RECEIVE_SMS
- READ_SMS
- INTERNET

---

## Message Format

Example:

```
📩 New SMS Received

From: +97059XXXXXXX

Message:
Your verification code is 123456
```

---

## Tech Stack

- Java
- Android SDK
- BroadcastReceiver
- HttpURLConnection
- Telegram Bot API

---

## Notes

- Internet permission is required to send messages.
- SMS permission must be granted by the user.
- The app uses Telegram's official Bot API for forwarding messages.

---

## Disclaimer

This project is provided for educational and personal automation purposes only.

Users are responsible for complying with all applicable laws, platform policies, and privacy requirements. Always obtain appropriate consent before processing or forwarding SMS messages.

---

## License

Feel free to modify, improve, and contribute.

---
