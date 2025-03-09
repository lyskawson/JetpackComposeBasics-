package com.example.layoutcomposables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layoutcomposables.dataclass.Person
import com.example.layoutcomposables.dataclass.personList


@Composable
fun PersonList(modifier: Modifier = Modifier) {
    //PersonListWithLazyColumn(personList = personList, modifier = modifier)
    PersonListWithColumn(personList = personList, modifier = modifier)

    
}


@Composable
fun PersonListWithLazyColumn(
    modifier: Modifier = Modifier,
    personList: List<Person>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items = personList){ person ->
            PersonItem(person = person)


        }
    }
}

@Composable
fun PersonListWithColumn(
    modifier: Modifier = Modifier,
    personList: List<Person>
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()).fillMaxWidth()
    ) {
        for(person in personList){
            PersonItem(person=person)

        }
    }
}



@Composable
fun PersonItem(
    person: Person,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxWidth().padding(8.dp).background(Color.Cyan)
    ) {
        Text(text = person.name,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(4.dp))
        Text(text = person.email,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(4.dp))
    }


}


@Preview
@Composable
private fun PersonListPreview() {
    PersonList()
}