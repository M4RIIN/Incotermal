import { ChartDataset } from './../../../node_modules/chart.js/dist/types/index.d';
export const defaultBarDataSet: ChartDataset<'bar'> = {
  type: 'bar',
  data: [],
  barThickness : 20,
  minBarLength: 2,
  categoryPercentage :0

}

export const defaultLineDataSet: ChartDataset<'line'> = {
  type: 'line',
  data: [],
  borderWidth: 2,
  fill: true
}

export const barChartOptions: any = {
  scaleShowVerticalLines: false,
  responsive: true,
  scales: {
          xAxes: [{
              stacked: true
          }],
          yAxes: [{
              stacked: true
          }]
      }
};

