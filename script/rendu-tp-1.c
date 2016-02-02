#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]) {

  printf("Question 2\n");
  printf("  java -jar bioseq.jar print-fasta-sequences test1.fasta\n");
  printf("Question 3\n");
  printf("  java -jar bioseq.jar print-fasta-stats test1.fasta\n");
  printf("Question 4\n");
  printf("  java -jar bioseq.jarlist-kmers 4 test1.fasta\n");
  printf("Question 5\n");
  printf("  java -jar bioseq.jar common-kmers 4 test1.fasta test2.fasta\n");
  printf("Question 9\n");
  printf("  java -jar bioseq.jar ratio-common-kmers 4 test1.fasta test2.fasta\n");
  printf("Question 11\n");
  printf("  java -jar bioseq.jar random-mutations 10 ebola-z.fasta\n");
  return 0;
}
