const monthsList = [
    'Janvier',
    'Février',
    'Mars',
    'Avril',
    'Mai',
    'Juin',
    'Juillet',
    'Août',
    'Septembre',
    'Octobre',
    'Novembre',
    'Décembre'
];

const daysList = [
    'Dimanche',
    'Lundi',
    'Mardi',
    'Mercredi',
    'Jeudi',
    'Vendredi',
    'Samedi'
];

function getDate(value) {

    const date = new Date(value);

    let year = date.getFullYear();
    let month = monthsList[date.getMonth()];
    let dayMonth = daysList[date.getDay()];
    let day = date.getDate();

    let fullDate = `${dayMonth} le ${day} ${month} ${year}`;

    return fullDate; // I.E. Mercredi le 9 Juin 2022
}
