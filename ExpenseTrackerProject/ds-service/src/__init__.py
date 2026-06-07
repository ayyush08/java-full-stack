from flask import Flask
from flask import request, jsonify
from service.messageService import MessageService

messageService = MessageService()

app = Flask(__name__)
app.config.from_pyfile('config.py')


@app.route('/v1/ds/message', methods=['POST'])
def handle_message():
    message = request.json.get('message')
    result = messageService.process_message(message)
    return jsonify(result.model_dump())
    
@app.route('/', methods=['GET'])
def home():
    return "Welcome to the Expense Tracker API!"


if __name__ == '__main__':
    app.run(
        host='localhost',
        port='5000',
        debug=True
    )