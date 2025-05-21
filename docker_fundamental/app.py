# Importing the Flask class from the flask module
from flask import Flask

# Creating an instance of the Flask application
app = Flask(__name__)

@app.route('/')
def hello_world():
    """
    Root endpoint of the application.
    
    Returns:
        str: A welcome message for visitors accessing the root URL.
    """
    return 'Hello Dosto, welcome to DevOps Zero To Hero (Junoon Batch 9)'

@app.route('/health')
def health():
    """
    Health check endpoint.
    
    Returns:
        str: A message indicating that the server is running properly.
    """
    return 'Server is up and running'
