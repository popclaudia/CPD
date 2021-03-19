#include "omp.h"
#include <iostream>

#define SIZE 10

void main()
{
float A[SIZE][SIZE], B[SIZE][SIZE], C[SIZE][SIZE], total;
int i, j, k, tid;
total = 0.0;
for (i = 0; i < SIZE; i++)
{
for (j = 0; j < SIZE; j++) {
    A[i][j] = (j + 1) * 1.0;
    B[i][j] = (j + 1) * 1.0;
}
        
}

printf("\nStarting values of matrix A and matrix b:\n");

for (i = 0; i < SIZE; i++)
{
printf(" A[%d]= ", i);
for (j = 0; j < SIZE; j++)
    printf("%.1f ", A[i][j]);
printf(" B[%d]= ", i);
for (j = 0; j < SIZE; j++)
    printf("%.1f ", B[i][j]);
printf("\n");
}

printf("\nResults by thread/row:\n");

/* Create a team of threads and scope variables */
#pragma omp parallel shared(A, B, C, total) private(tid, i)
{
tid = omp_get_thread_num();
/* Loop work-sharing construct - distribute rows of matrix */
// Try commenting this line and see what happens
#pragma omp for private(j, k)
for (i = 0; i < SIZE; i++)
{
    // printf("I'm thread %d in loop i = %d\n", omp_get_thread_num(), i);
    for (j = 0; j < SIZE; j++)
    {
        C[i][j] = 0;
        for (k = 0; k < SIZE; k++) 
        {
            // printf("I'm thread %d in loop j = %d\n", omp_get_thread_num(), i);
            C[i][j] += (A[i][k] * B[k][j]);
        }
           
       
    /* Update and display of running total must be serialized */
    // Try commenting this line instead..ot this line too and see what happens
#pragma omp critical
    {
        total = total + C[i][j];
        printf(" thread %d did row %d, col %d \tc[%d][%d]=%.2f\t", tid, i, j, i, j, C[i][j]);
        printf("Running total= %.2f\n", total);
    }
    }
}
/* end of parallel i loop */
}
/* end of parallel construct */
printf("\nMatrix-vector total - sum of all c[] = %.2f\n\n", total);
}