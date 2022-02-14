/* globals Chart:false, feather:false */

(function () {
  'use strict'

  feather.replace({ 'aria-hidden': 'true' })

  // Graphs
  var ctx = document.getElementById('myChart')

  var days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
  let dateToday = moment();

  let incomingChartData = document.getElementById('chartData').children[0];
  let outgoingChartData = document.getElementById('chartData').children[1];

  // eslint-disable-next-line no-unused-vars
  var myChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: [
        days[moment().subtract(6, 'days').weekday()],
        days[moment().subtract(5, 'days').weekday()],
        days[moment().subtract(4, 'days').weekday()],
        days[moment().subtract(3, 'days').weekday()],
        days[moment().subtract(2, 'days').weekday()],
        days[moment().subtract(1, 'days').weekday()],
        days[moment().weekday()]
    ],
            datasets: [{
        data: [
          incomingChartData.children[0].innerHTML,
          incomingChartData.children[1].innerHTML,
          incomingChartData.children[2].innerHTML,
          incomingChartData.children[3].innerHTML,
          incomingChartData.children[4].innerHTML,
          incomingChartData.children[5].innerHTML,
          incomingChartData.children[6].innerHTML,
        ],
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#019342',
        borderWidth: 4,
        pointBackgroundColor: '#29f559',
        cubicInterpolationMode: 'monotone',
        tension: 0.4,
        fill: false
      },
              {
                data: [
                  outgoingChartData.children[0].innerHTML,
                  outgoingChartData.children[1].innerHTML,
                  outgoingChartData.children[2].innerHTML,
                  outgoingChartData.children[3].innerHTML,
                  outgoingChartData.children[4].innerHTML,
                  outgoingChartData.children[5].innerHTML,
                  outgoingChartData.children[6].innerHTML,
                ],
                lineTension: 0,
                backgroundColor: 'transparent',
                borderColor: '#fc1f1f',
                borderWidth: 4,
                pointBackgroundColor: '#fa3e90'
              }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })

})()
