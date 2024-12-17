// src/index.js
import { ApolloServer } from 'apollo-server';
import typeDefs from './typeDefs.js';
import resolvers from './resolvers.js';
import sequelize from './db.js';

const server = new ApolloServer({
  typeDefs,
  resolvers,
});

const startServer = async () => {
  try {
    await sequelize.sync(); 
    console.log('Les tables ont été synchronisées.');
    
    const { url } = await server.listen(2024);
    console.log(`🚀 Serveur Apollo lancé à ${url}`);
  } catch (error) {
    console.error('Erreur lors du démarrage du serveur:', error);
  }
};

startServer();
