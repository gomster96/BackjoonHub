#include <stdio.h>

/*
C로 BFS 구현하려면
1. Queue 필요
2. Vector

*/
struct Element
{
    int r, c, cnt;
};
class Queue
{
private:
    Element *arr;    // 큐 원소 넣는 배열
    int q_size;      // 큐의 사이즈
    int frontCursor; // 큐의 front 가리키는 커서
    int rearCursor;  // 큐의 back 가리키는 커서
    int maxQueueSize;

public:
    Queue()
    {
        maxQueueSize = 1000001;
        q_size = 0;
        arr = new Element[maxQueueSize];
        frontCursor = 1;
        rearCursor = 0;
    }
    ~Queue()
    {
        delete[] arr;
    }
    void push(Element val)
    {
        rearCursor = ++rearCursor % maxQueueSize;
        arr[rearCursor] = val;
        q_size++;
    }
    void pop()
    {
        frontCursor++;
        q_size--;
    }
    Element front()
    {
        return arr[frontCursor];
    }
    Element back()
    {
        return arr[rearCursor];
    }
    bool isEmpty()
    {
        return q_size == 0;
    }
    int size()
    {
        return q_size;
    }
    void check()
    {
        for (int i = frontCursor; i <= rearCursor; i++)
        {
            printf(" %d", arr[i].cnt);
        }
        printf("\n");
    }
};

int n, m;
int map[1001][1001];
int gR, gC;
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
void print()
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            printf("%d ", map[i][j]);
        }
        printf("\n");
    }
}

int main()
{

    scanf("%d %d", &n, &m);
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            scanf(" %d", &map[i][j]);
            if (map[i][j] == 2)
            {
                gR = i;
                gC = j;
            }
            else if (map[i][j] == 1)
            {
                map[i][j] = 2147000000;
            }
        }
    }
    map[gR][gC] = 0;
    Queue q;
    q.push((Element){gR, gC, 0});
    while (!q.isEmpty())
    {
        Element cur = q.front();
        // q.check();
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int rr = cur.r + dy[i];
            int cc = cur.c + dx[i];

            if (rr >= 0 && rr < n && cc >= 0 && cc < m && (map[rr][cc] != 0) && (map[rr][cc] > cur.cnt + 1))
            {
                map[rr][cc] = cur.cnt + 1;
                q.push((Element){rr, cc, cur.cnt + 1});
            }
        }
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (map[i][j] == 2147000000)
            {
                map[i][j] = -1;
            }
        }
    }
    print();
    return 0;
}
/*
if (cur.r == 10 && cur.c == 14)
{
    printf("WHat\n");
    printf("map : %d\n", map[cur.r][cur.c]);
    printf("back : %d\n", q.back().cnt);
    printf("size : %d\n", q.size());
    printf("WHat Fin\n");
}*/