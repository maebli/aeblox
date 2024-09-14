#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MIN(a, b) ((a) < (b) ? (a) : (b))

typedef struct Node{
    const char* data;
    struct Node* next;
    struct Node* prev;
} Node;

static Node* head = NULL;

void insert(const char* data) {

    printf("Inserting '%s' \n",data);

    Node* new = (Node*)malloc(sizeof(Node));
    new->data = data;
    new->prev = NULL;
    new->next = NULL;
    
    Node* current = head;

    if(head == NULL){
        printf("First insert, attaching head\n");
        head = new;
    }else {
        while(current->next != NULL){
            current = current->next;
        }
        new->prev = current;
        current->next = new;
    }

}

Node* find(const char* data){

    printf("Searching '%s' \n",data);

    Node* current = head;
    while(current != NULL){
        size_t min_len = MIN(strlen(data),strlen(current->data));
        if(0==strncmp(data,current->data,min_len)){
            printf("Found!\n");
            break;
        }
        current = current->next;
    }

    return current;

}

void delete(const char* data){
    
    Node* found;
    while(found=find(data)){
       if(found->prev && found->next){
           found->prev->next = found->next; 
           found->next->prev = found->prev;
       }else if(found->prev){
           found->prev->next = NULL;
       }else if(found->next){
           head = found->next;
           head->prev = NULL;
       }
       free(found);
    }
}


int main() {

    for(int i = 0;i<10000;i++){
        insert("hello");
    }

    insert("world");
    find("world");
    delete("hello");
    return 0;
}



