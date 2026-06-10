from flask import Flask
from flask import request, jsonify
from service.messageService import MessageService
from kafka import KafkaProducer
import json

messageService = MessageService()
kafkaProducer = KafkaProducer(bootstrap_servers='localhost:9092'
                                , value_serializer=lambda v: json.dumps(v).encode("utf-8")
                              )
app = Flask(__name__)
app.config.from_pyfile('config.py')


@app.route('/v1/ds/message', methods=['POST'])
def handle_message():
    message = request.json.get('message')
    result = messageService.process_message(message)
    
    kafkaProducer.send(
    'expense_service',
    result.model_dump()
)
    return jsonify(result.json()), 200
    
@app.route('/', methods=['GET'])
def home():
    return "Welcome to the Expense Tracker API!"


if __name__ == '__main__':
    app.run(
        host='localhost',
        port='5000',
        debug=True
    )