# Text Summarizer

This project is a simple text summarization service built using Spring Boot and Apache OpenNLP. It extracts summaries from long texts by detecting sentences and returning the first three sentences as the summary.

## Features

- **REST API**: Exposes an endpoint for summarizing input text.
- **Simple Summarization**: Extracts up to the first 3 sentences from the provided text.
- **Apache OpenNLP Integration**: Utilizes OpenNLP's sentence detection capabilities for summarization.

## Requirements

- **Java 21** or higher
- **Maven**

## Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Manu-Tyagi90/Text-Summarizer.git
   cd textsummarizer
   ```

2. **Download the Sentence Detection Model:**

   This project requires the OpenNLP sentence detection model `en-sent.bin`. Download it from [Apache OpenNLP Models](https://opennlp.apache.org/models.html) and place it in the following directory:

   ```
   src/main/resources/models/
   ```

3. **Build the project:**

   ```bash
   mvn clean package
   ```

4. **Run the application:**

   ```bash
   mvn spring-boot:run
   ```

## API Endpoint

The application exposes the following REST endpoint:

- **URL:** `/api/summarize`
- **Method:** `POST`
- **Content-Type:** `application/json` or `text/plain`

**Request Example:**
```bash
curl -X POST -H "Content-Type: application/json" -d '"This is the first sentence. This is the second sentence. This is the third sentence. This is an extra sentence."
``` 

Link:
http://localhost:8080/api/summarize



**Response Example:**
```json
{
  "summary": "This is the first sentence. This is the second sentence. This is the third sentence."
}
```

## Project Structure
```plaintext
textsummarizer/
├── pom.xml
├── README.md
└── src
├── main
│ ├── java

│ │ └── com
│ │ └── example
│ │ └── textsummarizer
│ │ ├── TextsummarizerApplication.java
│ │ ├── controller
│ │ │ └── TextSummarizerController.java
│ │ └── service
│ │ └── TextSummarizerService.java
│ └── resources
│ └── models
│ └── en-sent.bin
```
*ScreenShots* : 
![Screenshot (2)](https://github.com/user-attachments/assets/30b2798f-d04e-4a1f-86b1-825b8e0f511f)


## License

This project is licensed under the MIT License.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for review.
