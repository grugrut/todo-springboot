FROM node:12

WORKDIR /app

COPY ./package.json ./package.json
COPY ./node_modules ./node_modules
COPY ./nuxt.config.js ./nuxt.config.js
COPY ./.nuxt ./.nuxt
COPY ./static ./static

EXPOSE 3000
CMD ["npm", "start"]
