document.addEventListener('DOMContentLoaded', function () {
    const endpoints = [
        { name: 'Albums', url: 'api/v1/db/getAlbums' },
        { name: 'Comments', url: 'api/v1/db/getComments' },
        { name: 'Photos', url: 'api/v1/db/getPhotos' },
        { name: 'Posts', url: 'api/v1/db/getPosts' },
        { name: 'Todos', url: 'api/v1/db/getTodos' },
        { name: 'Users', url: 'api/v1/db/getUsers' }
    ];

    endpoints.forEach(endpoint => {
        fetch(endpoint.url)
            .then(response => response.json())
            .then(data => {
                createTable(endpoint.name, data);
            })
            .catch(error => console.error('Error ved indhentning af data:', error));
    });

    function createTable(name, data) {
        const table = document.createElement('table');
        const caption = document.createElement('caption');
        caption.textContent = name;
        table.appendChild(caption);

        const thead = document.createElement('thead');
        const tbody = document.createElement('tbody');

        if (data.length > 0) {
            const headers = Object.keys(data[0]);
            const headerRow = document.createElement('tr');

            headers.forEach(header => {
                const th = document.createElement('th');
                th.textContent = header;
                headerRow.appendChild(th);
            });

            thead.appendChild(headerRow);

            data.forEach(item => {
                const row = document.createElement('tr');
                headers.forEach(header => {
                    const td = document.createElement('td');
                    td.textContent = item[header];
                    row.appendChild(td);
                });
                tbody.appendChild(row);
            });

            table.appendChild(thead);
            table.appendChild(tbody);
        } else {
            const row = document.createElement('tr');
            const td = document.createElement('td');
            td.textContent = `Ingen data for ${name}`;
            td.colSpan = headers.length;
            row.appendChild(td);
            tbody.appendChild(row);
            table.appendChild(tbody);
        }

        document.body.appendChild(table);
    }
});
