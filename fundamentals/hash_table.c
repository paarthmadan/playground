#include <stdlib.h>
#include <stdio.h>

#define LENGTH 10

typedef struct node {
    int val;
    struct node *next;
} Node;

// Hash table struct implementing separate chaining
typedef struct {
    int n;
    Node **buckets;
} ScHashTable;

void printAllKeys(ScHashTable *);
void insert(ScHashTable *, int k, int v);
int hash(int n, int k);

int main() {
    Node **buckets = (Node **)(malloc(sizeof(Node) * LENGTH));


    ScHashTable table = { LENGTH, buckets };
    printAllKeys(&table);

    insert(&table, 1, 5);
    insert(&table, 11, 10);
    insert(&table, 4, 10);
    insert(&table, 24, 3);

    printAllKeys(&table);
}

void printAllKeys(ScHashTable *table) {
    printf("---------------------------------\n");
    Node **buckets = table->buckets;
    for (int i = 0; i < table->n; i++) {
        if (buckets[i] == NULL)
            printf("%d: NULL\n", i);
        else {
            Node *bucket = buckets[i];
            printf("%d: %d->", i, bucket->val);
            while(bucket->next != NULL) {
                printf("%d->", bucket->next->val);
                bucket = bucket->next;
            }
            printf("\n");
        }
    }
    printf("---------------------------------\n");
}

void insert(ScHashTable *table, int k, int v) {
    int i = hash(table->n, k);
    Node **buckets = table->buckets;

    if (buckets[i] == NULL) {
        buckets[i] = (Node *)malloc(sizeof(Node));
        buckets[i]->val = v;
    } else {
        Node *bucket = buckets[i];
        while(bucket->next != NULL) {
            if(bucket->val == v)
                return;
            bucket = bucket->next;
        }
        bucket->next = malloc(sizeof(Node));
        bucket->next->val = v;
    }
}

// Take k, some integer possibly outside the domain of buckets, and confine it to the domain of bucket space
// Use simple modular hashing (since we're dealing with randomly distributed integers as keys)
int hash(int n, int k) {
    return k % n;
}

