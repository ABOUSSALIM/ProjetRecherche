// src/db.js
import { Sequelize } from 'sequelize';

const sequelize = new Sequelize('db1', 'postgres', 'graphql', {
  host: 'localhost',
  dialect: 'postgres',
  port: 5050,
});

try {
  await sequelize.authenticate();
  console.log('Connexion à la base de données PostgreSQL réussie');
} catch (error) {
  console.error('Impossible de se connecter à la base de données:', error);
}

export default sequelize;
