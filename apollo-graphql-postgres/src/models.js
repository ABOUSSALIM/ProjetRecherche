import { DataTypes } from 'sequelize';
import sequelize from './db.js';

// Modèle Client
const Client = sequelize.define('Client', {
  id: {
    type: DataTypes.INTEGER,
    primaryKey: true, // Spécifie que c'est la clé primaire
    autoIncrement: true, // ID incrémenté automatiquement
  },
  nom: {
    type: DataTypes.STRING,
    allowNull: false,
  },
  prenom: {
    type: DataTypes.STRING,
    allowNull: true,
  },
  email: {
    type: DataTypes.STRING,
    allowNull: true,
  },
  telephone: {
    type: DataTypes.STRING,
    allowNull: true,
  },
});

// Modèle Chambre
const Chambre = sequelize.define('Chambre', {
  id: {
    type: DataTypes.INTEGER,
    primaryKey: true,
    autoIncrement: true,
  },
  type: {
    type: DataTypes.STRING,
    allowNull: true,
  },
  prix: {
    type: DataTypes.FLOAT,
    allowNull: true,
  },
  disponible: {
    type: DataTypes.BOOLEAN,
    allowNull: true,
  },
});

// Modèle Reservation
const Reservation = sequelize.define('Reservation', {
  id: {
    type: DataTypes.INTEGER,
    primaryKey: true,
    autoIncrement: true,
  },
  dateDebut: {
    type: DataTypes.STRING,
    allowNull: true,
  },
  dateFin: {
    type: DataTypes.STRING,
    allowNull: true,
  },
  preferences: {
    type: DataTypes.STRING,
    allowNull: true,
  },
});

// Modèle Reservation
 // Assurez-vous que le champ 'clientId' existe dans la table Reservation
Client.hasMany(Reservation, { foreignKey: 'clientId' });  // Une réservation appartient à un client

Reservation.belongsTo(Client, { foreignKey: 'clientId', as: 'client' }); 
Reservation.belongsTo(Chambre, { foreignKey: 'chambreId', as: 'chambre' });

Chambre.hasMany(Reservation, { foreignKey: 'chambreId' });  // Une réservation appartient à une chambre


export { Client, Chambre, Reservation };

