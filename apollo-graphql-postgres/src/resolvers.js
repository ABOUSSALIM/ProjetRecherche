import { Client, Chambre, Reservation } from './models.js';

const resolvers = {
  Query: {
    // Récupérer tous les clients
    getClients: async () => {
      try {
        return await Client.findAll();
      } catch (error) {
        console.error('Erreur lors de la récupération des clients:', error);
        return [];
      }
    },

    // Récupérer toutes les chambres
    getChambres: async () => {
      try {
        return await Chambre.findAll();
      } catch (error) {
        console.error('Erreur lors de la récupération des chambres:', error);
        return [];
      }
    },

 // Récupérer toutes les réservations
 getReservations: async () => {
  try {
    const reservations = await Reservation.findAll({
      include: [
        {
          model: Client,
          as: 'client', 
         
        },
        {
          model: Chambre,
          as: 'chambre', 
         
        },
      ],
    });

    return reservations;
  } catch (error) {
    console.error('Erreur lors de la récupération des réservations:', error);
    return [];
  }
},



    // Récupérer une réservation par ID
  getReservation: async (_, { id }) => {
      try {
    const reservation = await Reservation.findByPk(id, {
         include: [
            { model: Client, as: 'client' },
            { model: Chambre, as: 'chambre' },
         ],
      });
        return reservation ;
      } catch (error) {
        console.error('Erreur lors de la récupération de la réservation:', error);
        return null;
      }
    },
  },

  Mutation: {
    // Créer un client
    creerClient: async (_, { client }) => {
      try {
        const newClient = await Client.create(client);
        return newClient;
      } catch (error) {
        console.error('Erreur lors de la création du client:', error);
        throw new Error('Impossible de créer le client');
      }
    },

    // Créer une chambre
    creerChambre: async (_, { chambre }) => {
      try {
        const newChambre = await Chambre.create(chambre);
        return newChambre;
      } catch (error) {
        console.error('Erreur lors de la création de la chambre:', error);
        throw new Error('Impossible de créer la chambre');
      }
    },

    // Créer une réservation
    creerReservation: async (_, { reservation }) => {
      try {
        // Vérification de l'existence du client
        const clientExist = await Client.findByPk(reservation.clientId);
        if (!clientExist) {
          throw new Error('Client non trouvé');
        }
    
        // Vérification de l'existence de la chambre
        const chambreExist = await Chambre.findByPk(reservation.chambreId);
        if (!chambreExist) {
          throw new Error('Chambre non trouvée');
        }
    
        // Création de la réservation
        const newReservation = await Reservation.create({
          clientId: reservation.clientId,
          chambreId: reservation.chambreId,
          dateDebut: reservation.dateDebut,
          dateFin: reservation.dateFin,
          preferences: reservation.preferences,
        });
    
        // Retourner la réservation avec les informations complètes
        const client = await Client.findByPk(reservation.clientId);
        const chambre = await Chambre.findByPk(reservation.chambreId);
    
        return {
          id: newReservation.id,
          client: client,
          chambre: chambre,
          dateDebut: newReservation.dateDebut,
          dateFin: newReservation.dateFin,
          preferences: newReservation.preferences,
        };
      } catch (error) {
        console.error('Erreur lors de la création de la réservation:', error);
        throw new Error('Impossible de créer la réservation');
      }
    },

     //  Supprimer un client
     deleteClient: async (_, { id }) => {
      try {
        const result = await Client.destroy({ where: { id } });
        return result > 0;
      } catch (error) {
        console.error("Erreur lors de la suppression du client :", error);
        return false;
      }
    },
    //  Supprimer un client
    deleteChambre: async (_, { id }) => {
      try {
        const result = await Chambre.destroy({ where: { id } });
        return result > 0;
      } catch (error) {
        console.error("Erreur lors de la suppression de la chambre :", error);
        return false;
      }
    },

        // Supprimer une réservation
        deleteReservation: async (_, { id }) => {
          try {
            const result = await Reservation.destroy({ where: { id } });
            return result > 0;
          } catch (error) {
            console.error("Erreur lors de la suppression de la réservation :", error);
            return false;
          }
        },
    
        // Mettre à jour une réservation
        updateReservation: async (_, { id, newReservation }) => {
          try {
            // Récupérer la réservation existante
            const reservation = await Reservation.findByPk(id);
            if (!reservation) {
              throw new Error("Réservation introuvable");
            }
        
            // Vérifier si le client doit être mis à jour
            if (newReservation.clientId && newReservation.clientId !== reservation.clientId) {
              const clientExist = await Client.findByPk(newReservation.clientId);
              if (!clientExist) {
                throw new Error('Client non trouvé');
              }
            }
        
            // Mise à jour de la réservation avec les nouvelles données
            await reservation.update(newReservation);
        
            // Récupérer les informations actualisées
            const client = await Client.findByPk(reservation.clientId);
            const chambre = await Chambre.findByPk(reservation.chambreId);
        
            // Retourner les informations complètes de la réservation mise à jour
            return {
              id: reservation.id,
              client: client,
              chambre: chambre,
              dateDebut: reservation.dateDebut,
              dateFin: reservation.dateFin,
              preferences: reservation.preferences,
            };
          } catch (error) {
            console.error("Erreur lors de la mise à jour de la réservation :", error);
            throw new Error("Erreur lors de la mise à jour de la réservation");
          }
        },
        
      },
};

export default resolvers;
