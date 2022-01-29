FROM node:16.13

WORKDIR /app
COPY . .

RUN npm install -g npm@8.4.0 
RUN npm install -g @angular/cli 
RUN npm install

CMD ng serve