FROM node:16.13

WORKDIR /app
COPY . .

RUN npm install -g npm@8.4.0 
RUN npm install -g @angular/cli 
RUN yarn install

CMD ng serve
