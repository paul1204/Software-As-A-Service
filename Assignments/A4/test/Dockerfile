FROM alpine:3.8
RUN apk add python3 py-pip && python3 -m ensurepip && pip install --upgrade pip && pip install flask && pip install -U pytest
WORKDIR /app
COPY . /app/
RUN pip install -r requirements.txt 
ENTRYPOINT ["pytest"]
CMD ["shuffleTest.py"]