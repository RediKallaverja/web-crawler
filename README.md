# web-crawler

Simple Java Web Crawler.

The logic of the application is as below:

- Gets a string (search term) as query param
- Get a Google result page for the search term
- Extract main result links from the page
- Download the respective pages and extract the names of javascript libraries used in them
- Returns top 5 most used libraries as Json response


Test the application:

- Clone this repository to your local machine
- Run the project 
- Call from postman or browser this URL http://localhost:8080/web-crawler?q={YOUR_SEARCH_TERM}
- You should expect a response in this structure
```json
[
    {
        "libCount": 7,
        "javascriptLib": "jquery.min.js"
    },
    {
        "libCount": 5,
        "javascriptLib": "index.js"
    }
]
```
