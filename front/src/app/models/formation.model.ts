import Session from "./session.model";
import Theme from "./theme.model";


export default class Formation  {
  id: number;
  reference : string;
  intitule: string;
  publicConcerne: string;
  description: string;
  objectif: string;
  prerequis: string;
  duree: string;
  estIntra: boolean;
  distanciel: boolean;
  image: string;
  tarif: number;
  theme: Theme;
  session : Session;

  constructor(id: number, reference : string, intitule: string, publicConcerne: string, description: string, objectif: string, prerequis: string, duree: string, estIntra: boolean, distanciel: boolean, image: string, tarif: number, theme: Theme, session : Session){

    this.id = id;
    this.reference = reference;
    this.intitule = intitule;
    this.publicConcerne = publicConcerne;
    this.description = description;
    this.objectif = objectif;
    this.prerequis = prerequis;
    this.duree = duree;
    this.estIntra = estIntra;
    this.distanciel = distanciel;
    this.image = image;
    this.tarif = tarif;
    this.theme = theme;
    this.session = session;
  }
}
